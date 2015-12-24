package com.remix.domain;

import java.io.Serializable;

public class Book implements Serializable {
	private String id;//一本书的唯一标识
	private String isbn;
	private String name;
	private String author;
	private float price;//价格
	private String descriptions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public Book(String id, String isbn, String name, String author,
			float price, String descriptions) {
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.price = price;
		this.descriptions = descriptions;
	}
	public Book() {
	}
	
}
