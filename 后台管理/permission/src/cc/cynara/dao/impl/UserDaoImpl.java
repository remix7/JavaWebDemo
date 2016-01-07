package cc.cynara.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.dao.UserDao;
import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.domain.User;
import cc.cynara.exception.DaoException;
import cc.cynara.util.DBCPUtils;
import cc.cynara.util.MD5Utils;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	public List<User> findAllUser() {
		try {
			return qr.query("select * from user", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void addUser(User u) {
		try {
			qr.update("insert into user(id,username,password,nick) values(?,?,?,?)",u.getId(),u.getUsername(),MD5Utils.encoding(u.getPassword()),u.getNick());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void delOneUser(String userId) {
		try {
			qr.update("delete from user where id=?", userId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public User findUserById(String userId) {
		try {
			User u = qr.query("select * from user where id=?", new BeanHandler<User>(User.class), userId);
			if(u!=null){
				List<Role> roles = qr.query("select * from role where id in (select r_id from role_user where u_id=?)", new BeanListHandler<Role>(Role.class), userId);
				u.setRoles(roles);
			}
			return u;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void updateUser(User u) {
		User u1 = findUserById(u.getId());
		if(u1!=null){
			try {
				qr.update("update user set username=?,password=?,nick=? where id=?", u.getUsername(),MD5Utils.encoding(u.getPassword()),u.getNick(),u.getId());
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}
	public User unionFindUserById(String userId) {
		try {
			 User u = qr.query("select * from user where id=?", new BeanHandler<User>(User.class), userId);
			 if(u!=null){
				 List<Role> roles = qr.query("select * from role where id in(select r_id from role_user where u_id=?)", new BeanListHandler<Role>(Role.class), userId);
				 u.setRoles(roles);
			 }
			 return u;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void delRoleRelation(String userId) {
		try {
			qr.update("delete from role_user where u_id=?",userId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void grantRole2User(String uesrId, String[] rIds) {
		Object params[][] = new Object[rIds.length][];
		for(int i=0;i<rIds.length;i++){
			params[i] = new Object[]{rIds[i],uesrId};
		}
		try {
			qr.batch("insert into role_user(r_id,u_id) values(?,?)", params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void delRoleRelationByRoleId(String roleId) {
		try {
			qr.update("delete from role_user where r_id=?",roleId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public User findUserByUsernameAndPassword(String username, String password) {
		try {
			User u = qr.query("select * from user where username=? and password=?", new BeanHandler<User>(User.class), username,MD5Utils.encoding(password));
			return u;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public User findUserByUsername(String username) {
		try {
			User u = qr.query("select * from user where username=?", new BeanHandler<User>(User.class), username);
			return u;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
