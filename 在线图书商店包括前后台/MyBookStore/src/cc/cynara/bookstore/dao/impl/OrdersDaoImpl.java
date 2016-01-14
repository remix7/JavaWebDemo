package cc.cynara.bookstore.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.bookstore.dao.OrdersDao;
import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.OrderItem;
import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.User;
import cc.cynara.bookstore.exception.DaoException;
import cc.cynara.bookstore.util.DBCPUtils;

public class OrdersDaoImpl implements OrdersDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	public void addOrders(Orders orders, User user) {
		try {
			qr.update("insert into orders(id,ordernum,num,price,user_id) values(?,?,?,?,?)",orders.getId(),orders.getOrdernum(),orders.getNum(),orders.getPrice(),user.getId());
			List<OrderItem> items = orders.getItems();
			if(items!=null&&items.size()>0){
				String sql = "insert into orderitem(id,num,price,orders_id,book_id) values(?,?,?,?,?)";
				Object pps[][] = new Object[items.size()][];
				for(int i=0;i<items.size();i++){
					OrderItem item = items.get(i);
					pps[i] = new Object[]{item.getId(),item.getNum(),item.getPrice(),orders.getId(),item.getBook().getId()};
				}
				qr.batch(sql, pps);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public List<Orders> findOrdersByUserId(String id) {
		try {
			return qr.query("select * from orders where user_id=? order by ordernum desc", new BeanListHandler<Orders>(Orders.class), id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public Orders findORdersById(String orderId) {
		try {
			Orders o = qr.query("select * from orders where id=?", new BeanHandler<Orders>(Orders.class), orderId);
			if(o!=null){
				User u = qr.query("select * from user where id=(select user_id from orders where id=?)", new BeanHandler<User>(User.class), orderId);
				o.setUser(u);
				
				List<OrderItem> items = qr.query("select * from orderitem where orders_id=?", new BeanListHandler<OrderItem>(OrderItem.class), orderId);
				if(items!=null&&items.size()>0){
					for (OrderItem item : items) {
						Book b = qr.query("select * from book where id=(select book_id from orderitem where id=?)", new BeanHandler<Book>(Book.class), item.getId());
						item.setBook(b);
					}
				}
				o.setItems(items);
			}
			return o;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public List<Orders> findOrdersByState(int i) {
		try {
			List<Orders> orders =  qr.query("select * from orders where state=? order by ordernum desc", new BeanListHandler<Orders>(Orders.class), i);
			//查询出对用的用户信息
			if(orders!=null&&orders.size()>0){
				for (Orders orders2 : orders) {
					User user = qr.query("select * from user where id=(select user_id from orders where id=?)", new BeanHandler<User>(User.class), orders2.getId());
					orders2.setUser(user);
				}
			}
			return orders;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
	public void updateOrder(String orderId) {
		try {
			qr.update("update orders set state=1 where id=?", orderId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
