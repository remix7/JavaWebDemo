package cc.cynara.bookstore.domain;

import java.io.Serializable;

public class Book implements Serializable {
	private String id;
	private String name;
	private String author;
	private float price;
	private String image;
	private String description;
	private String category_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String categoryId) {
		category_id = categoryId;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", category_id=" + category_id
				+ ", description=" + description + ", id=" + id + ", image="
				+ image + ", name=" + name + ", price=" + price + "]";
	}
	
}
