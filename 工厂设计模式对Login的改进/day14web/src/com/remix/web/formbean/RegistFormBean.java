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
		//����д����Map�����Ӷ���
		//�û���3-8��ĸ
		if(username==null||"".equals(username.trim())){
			errors.put("username", "�������û�����");
		}else{
			if(!username.matches("[a-zA-Z]{2,8}")){
				errors.put("username", "�û���������3-8λ����ĸ��ɣ�");
			}
		}
		//����3-8����
		if(password==null||"".equals(password.trim())){
			errors.put("password", "���������룡");
		}else{
			if(!password.matches("\\d{3,10}")){
				errors.put("password", "���������3-8λ��������ɣ�");
			}
		}
		//�ظ�����
		if(!password.equals(password1)){
			errors.put("password1", "�����������һ�£�");
		}
		//����
		if(email==null||"".equals(email.trim())){
			errors.put("email", "���������䣡");
		}else{
			if(!email.matches("\\w+@\\w+(.\\w+)+")){
				errors.put("email", "��������ȷ�����䣡");
			}
		}
		//��������
		if(brithday==null||"".equals(brithday.trim())){
			errors.put("brithday", "������������ڣ�");
		}else{
			DateLocaleConverter dlc = new DateLocaleConverter();
			try {
				dlc.convert(brithday);
			} catch (Exception e) {
				e.printStackTrace();
				errors.put("brithday", "��������ȷ�����ڣ�[����2015-12-23]");
			}
		}
		return errors.isEmpty();
	}
	
}
