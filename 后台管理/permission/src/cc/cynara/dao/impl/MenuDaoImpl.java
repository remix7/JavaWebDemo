package cc.cynara.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.dao.MenuDao;
import cc.cynara.domain.Menu;
import cc.cynara.exception.DaoException;
import cc.cynara.util.DBCPUtils;

public class MenuDaoImpl implements MenuDao  {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());

	public List<Menu> FindAllMenu() {
		try {
			return qr.query("select * from menu", new BeanListHandler<Menu>(Menu.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void addMenu(Menu m) {
		try {
			qr.update("insert into menu(id,name,uri,description) values(?,?,?,?)",m.getId(), m.getName(), m.getUri(), m.getDescription());
		} catch (Exception e) {
			
		}
	}

	public void deleteMenu(String menuId) {
		try {
			qr.update("delete from menu where id=?", menuId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public Menu findMenuById(String menuId) {
		try {
			return qr.query("select * from menu where id=?", new BeanHandler<Menu>(Menu.class), menuId);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void updateMenu(Menu m) {
		Menu m1 = findMenuById(m.getId());
		if(m1!=null){
			try {
				qr.update("update menu set name=?,uri=?,description=? where id=?", m.getName(),m.getUri(),m.getDescription(),m.getId());
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}

}
