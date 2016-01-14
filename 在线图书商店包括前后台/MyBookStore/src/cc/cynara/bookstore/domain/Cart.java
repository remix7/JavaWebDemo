package cc.cynara.bookstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
	//key 购物项对应的书  value 购物项
	private Map<String, CartItem> items = new HashMap<String, CartItem>();
	private int num; //数量
	private float price;//总计
	public Map<String, CartItem> getItems() {
		return items;
	}
	public int getNum() {
		num=0;
		for(Map.Entry<String, CartItem> me :items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		price=0;
		for(Map.Entry<String, CartItem> me :items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void addBook(Book book) {
		if(items.containsKey(book.getId())){
			//购物车里有
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			//购物车里没有
			CartItem item = new CartItem();
			item.setBook(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
	
}
