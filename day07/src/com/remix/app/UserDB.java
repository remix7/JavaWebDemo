package com.remix.app;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("sha","123456"));
		users.add(new User("diao", "123456"));
		users.add(new User("zhu", "123456"));
	}
	public static User findUser(String username,String password){
		User user = null;
		for(User u :users){
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())){
				user = u;
				break;
			}
		}
		return user;
	}
}	
