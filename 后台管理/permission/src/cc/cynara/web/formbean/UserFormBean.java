package cc.cynara.web.formbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.cynara.domain.Role;
import cc.cynara.domain.User;

public class UserFormBean {
	private String username;
	private String password;
	private String nick;
	private List<Role> Users = new ArrayList<Role>();
	Map<String, String> errors = new HashMap<String, String>();
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
	public List<Role> getUsers() {
		return Users;
	}
	public void setUsers(List<Role> users) {
		Users = users;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){
		if(username==null||"".equals(username)){
			errors.put("username", "用户名为必填项!");
		}
		if(password==null||"".equals(password)){
			errors.put("password", "密码为必填项!");
		}
		if(nick==null||"".equals(nick)){
			errors.put("nick", "昵称为必填项!");
		}
		return errors.isEmpty();
	}
	
}
