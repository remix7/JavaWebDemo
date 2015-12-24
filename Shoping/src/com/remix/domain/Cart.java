package com.remix.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
//购物车
public class Cart implements Serializable{
	//key购物项中的书的id value 购物项
	private Map<String, CartItem> items = new LinkedHashMap<String, CartItem>();
	private int num;
	private float price;
	public Map<String, CartItem> getItems() {
		return items;
	}
	public int getNum() {
		num = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			num+=me.getValue().getNum();
		}
		return num;
	}
	public float getPrice() {
		price = 0;
		for(Map.Entry<String, CartItem> me : items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}
	/**
	 * 把购买的书 放入购物车中
	 * @param book
	 */
	public void addBook2Cart(Book book){
		//判断买的书之前有没有买过
		if(items.containsKey(book.getId())){
			//买过数量加1
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			//没买过  创建一个新的购物项  加入到items中
			CartItem item = new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
}	
