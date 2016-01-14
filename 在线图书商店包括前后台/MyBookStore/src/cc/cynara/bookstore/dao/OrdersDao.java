package cc.cynara.bookstore.dao;

import java.util.List;

import cc.cynara.bookstore.domain.Orders;
import cc.cynara.bookstore.domain.User;

public interface OrdersDao {
	/**
	 * 添加订单 保存到数据库中
	 * @param orders
	 * @param user
	 */
	void addOrders(Orders orders, User user);
	/**
	 * 用户查看修改订单  根据用户的Id
	 * @param id
	 * @return
	 */
	List<Orders> findOrdersByUserId(String id);
	/**
	 *  根据订单号查询出订单和用户的信息
	 * @param orderId
	 * @return
	 */
	Orders findORdersById(String orderId);
	/**
	 * 根据状态码  查询订单信息
	 * @param i
	 * @return
	 */
	List<Orders> findOrdersByState(int i);
	/**
	 * 将订单标记为已发货
	 * @param orderId
	 */
	void updateOrder(String orderId);

}
