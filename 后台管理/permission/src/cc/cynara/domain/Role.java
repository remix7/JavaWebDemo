package cc.cynara.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 create table role(
 	id varchar(100) primary key,
 	name varchar(100) unique,
 	description varchar(255)
 );
 * @author REMIX-7
 *
 */
public class Role implements Serializable {
	private String id;
	private String name;
	private String description;
	private List<Menu> menus = new ArrayList<Menu>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
