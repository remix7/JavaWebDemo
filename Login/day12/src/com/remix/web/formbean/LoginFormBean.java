package com.remix.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class LoginFormBean {
	private String username;
	private String password;
	private Map<String , String> errors = new HashMap<String, String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){
		if(username == null||"".equals(username.trim())){
			errors.put("username", "请输入用户名！");
		}
		if(password == null||"".equals(password.trim())){
			errors.put("password", "请输入密码！");
		}
		return errors.isEmpty();
	}
}
