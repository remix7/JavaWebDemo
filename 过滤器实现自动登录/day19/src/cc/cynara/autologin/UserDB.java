package cc.cynara.autologin;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
	private static List<User> users = new ArrayList<User>();
	static{
		users.add(new User("lt", "123456", "刘涛"));
		users.add(new User("ls", "123456", "李四"));
		users.add(new User("你好", "123456", "李四"));
	}
	public static User findUser(String username,String password){
		User user = null;
		for(User u:users ){
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())){
				user = u;
				break;
			}
		}
		return user;
	}
	public static User findUser(String username){
		User user = null;
		for(User u:users ){
			if(username.equals(u.getUsername())){
				user = u;
				break;
			}
		}
		return user;
	}
}
