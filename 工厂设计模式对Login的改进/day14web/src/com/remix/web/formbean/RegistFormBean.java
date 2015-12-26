package com.remix.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegistFormBean {
	private String username;
	private String password;
	private String nick;
	private String password1;
	private String email;
	private String brithday;
	
	private Map<String, String> errors = new HashMap<String, String>();
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){
		//如果有错就往Map里增加东西
		//用户名3-8字母
		if(username==null||"".equals(username.trim())){
			errors.put("username", "请输入用户名！");
		}else{
			if(!username.matches("[a-zA-Z]{2,8}")){
				errors.put("username", "用户名必须是3-8位的字母组成！");
			}
		}
		//密码3-8数字
		if(password==null||"".equals(password.trim())){
			errors.put("password", "请输入密码！");
		}else{
			if(!password.matches("\\d{3,10}")){
				errors.put("password", "密码必须是3-8位的数字组成！");
			}
		}
		//重复密码
		if(!password.equals(password1)){
			errors.put("password1", "两次密码必须一致！");
		}
		//邮箱
		if(email==null||"".equals(email.trim())){
			errors.put("email", "请输入邮箱！");
		}else{
			if(!email.matches("\\w+@\\w+(.\\w+)+")){
				errors.put("email", "请输入正确的邮箱！");
			}
		}
		//出生日期
		if(brithday==null||"".equals(brithday.trim())){
			errors.put("brithday", "请输入出生日期！");
		}else{
			DateLocaleConverter dlc = new DateLocaleConverter();
			try {
				dlc.convert(brithday);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("brithday", "请输入正确的日期！[比如2015-12-23]");
			}
		}
		return errors.isEmpty();
	}
	
}
