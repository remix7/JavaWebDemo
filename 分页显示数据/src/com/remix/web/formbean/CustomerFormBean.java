package com.remix.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class CustomerFormBean {
	private String id;
	private String name;
	private String gender;
	private String birthday;
	private String cellphone;
	private String email;
	private String[] hobbies;
	private String type;
	private String description;
	Map<String, String> errors = new HashMap<String, String>();
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){
		if(birthday!=null&&!"".equals(birthday.toString())){
			try {
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday);
			} catch (Exception e) {
				errors.put("birthday", "请输入正确的日期！");
			}
			if(birthday==null||"".equals(birthday)){
				errors.put("birthday", "日期必须输入！");
			}
		}
		
		return errors.isEmpty();
	}
}
