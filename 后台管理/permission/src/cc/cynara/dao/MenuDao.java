package cc.cynara.dao;

import java.util.List;

import cc.cynara.domain.Menu;

public interface MenuDao {
	/**
	 * 添加一个菜单
	 * @param m
	 */
	public void addMenu(Menu m);
	/**
	 * 查询所有的menu
	 * @return list
	 */
	public List<Menu> FindAllMenu();
	/**
	 * 根据id查询菜单
	 * @param menuId
	 * @return menu
	 */
	public Menu findMenuById(String menuId);
	/**
	 * 修改菜单
	 * @param m
	 */
	public void updateMenu(Menu m);
	/**
	 * 根据菜单的ID删除菜单
	 * @param menuId
	 */
	public void deleteMenu(String menuId);
}
