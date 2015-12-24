package com.remix.domain;

import java.io.Serializable;

//π∫ŒÔœ‡
public class CartItem implements Serializable {
	private Book book;
	private int num;
	private float price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return num*book.getPrice();
	}
	public CartItem(Book book) {
		this.book = book;
	}

}
