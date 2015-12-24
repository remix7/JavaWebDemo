package com.remix.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String username;//Ψһ
	private String nick;
	private String password;
	private String email;
	private Date brithday;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public User(String username, String nick, String password, String email,
			Date brithday) {
		super();
		this.username = username;
		this.nick = nick;
		this.password = password;
		this.email = email;
		this.brithday = brithday;
	}
	public User() {
	}
	
	
}
