package cc.cynara.domain;

import java.io.Serializable;

public class Account implements Serializable{
	private int id;
	private String name;
	private float mony;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMony() {
		return mony;
	}
	public void setMony(float mony) {
		this.mony = mony;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", mony=" + mony + ", name=" + name + "]";
	}
	
	
}
