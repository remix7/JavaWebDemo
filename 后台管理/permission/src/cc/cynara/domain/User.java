package cc.cynara.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
create table user(
	id varchar(100) primary key,
	username varchar(100) unique not null,
	password varchar(100),
	nick varchar(100)
);
 * @author REMIX-7
 *
 */
public class User implements Serializable {
	private String id;
	private String username;
	private String password;
	private String nick;
	private List<Role> roles = new ArrayList<Role>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
