package cc.cynara.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import cc.cynara.bookstore.util.OrdersId;
//将用户的订单信息保存到数据库中
public class Orders implements Serializable {
	private String id;
	private String ordernum;
	private int num;
	private float price;
	private int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
