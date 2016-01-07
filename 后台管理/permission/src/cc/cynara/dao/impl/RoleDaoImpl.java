package cc.cynara.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.dao.RoelDao;
import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.exception.DaoException;
import cc.cynara.util.DBCPUtils;

public class RoleDaoImpl implements RoelDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	public List<Role> findAllRole() {
		try {
			return qr.query("select * from role", new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void addRole(Role r) {
		try {
			qr.update("insert into role(id,name,description) values(?,?,?)", r.getId(),r.getName(),r.getDescription());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void delOneRole(String roleId) {
		try {
			qr.update("delete from role where id=?", roleId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public Role findRoleById(String roleId) {
		try {
			Role r =  qr.query("select * from role where id=?", new BeanHandler<Role>(Role.class), roleId);
			if(r!=null){
				List<Menu> menus = qr.query("select * from menu where id in (select m_id from menu_role where r_id=?)", new BeanListHandler<Menu>(Menu.class), roleId);
				r.setMenus(menus);
			}
			return r;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void updateRole(Role r) {
		Role r1 = findRoleById(r.getId());
		if(r1!=null){
			try {
				qr.update("update role set name=?,description=? where id=?", r.getName(),r.getDescription(),r.getId());
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}
	public Role unionFindRoleById(String roleId) {
		try {
			 Role r = qr.query("select * from role where id=?", new BeanHandler<Role>(Role.class), roleId);
			 if(r!=null){
				 List<Menu> menus = qr.query("select * from menu where id in(select m_id from menu_role where r_id=?)", new BeanListHandler<Menu>(Menu.class), roleId);
				 r.setMenus(menus);
			 }
			 return r;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void delMenuRelation(String roleId) {
		try {
			qr.update("delete from menu_role where r_id=?", roleId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	public void grantMenu2Role(String roleId, String[] mIds) {
		
		Object params[][] = new Object[mIds.length][];
		for(int i=0;i<mIds.length;i++){
			params[i] = new Object[]{mIds[i],roleId};
		}
		
		try {
			qr.batch("insert into menu_role(m_id,r_id) values(?,?)", params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	

}
