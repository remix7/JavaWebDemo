package cc.cynara.domain;

import java.io.Serializable;

public class User implements Serializable{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
