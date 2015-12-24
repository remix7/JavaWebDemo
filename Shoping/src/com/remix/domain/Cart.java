package com.remix.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
//���ﳵ
public class Cart implements Serializable{
	//key�������е����id value ������
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
	 * �ѹ������ ���빺�ﳵ��
	 * @param book
	 */
	public void addBook2Cart(Book book){
		//�ж������֮ǰ��û�����
		if(items.containsKey(book.getId())){
			//���������1
			CartItem item = items.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			//û���  ����һ���µĹ�����  ���뵽items��
			CartItem item = new CartItem(book);
			item.setNum(1);
			items.put(book.getId(), item);
		}
	}
}	
