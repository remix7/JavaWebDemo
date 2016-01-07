package cc.cynara.service;

import java.util.List;

import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.domain.User;

public interface BuinessService {
	/**
	 * 添加一个菜单
	 * 
	 * @param m
	 */
	public void addMenu(Menu m);

	/**
	 * 查询所有的menu
	 * 
	 * @return list
	 */
	public List<Menu> FindAllMenu();

	/**
	 * 根据id查询菜单
	 * 
	 * @param menuId
	 * @return menu
	 */
	public Menu findMenuById(String menuId);

	/**
	 * 修改菜单
	 * 
	 * @param m
	 */
	public void updateMenu(Menu m);

	/**
	 * 根据菜单的ID删除菜单
	 * 
	 * @param menuId
	 */
	public void deleteMenu(String menuId);
	/**
	 * 查询所有的角色
	 * @return
	 */
	public List<Role> findAllRole();
	/**
	 * 添加一个角色
	 * @param r
	 */
	public void addRole(Role r);
	/**
	 * 根据角色ID删除角色
	 * @param del
	 */
	public void delOneRole(String delRoleId);
	/**
	 *  查询一个角色
	 * @param parameter
	 * @return
	 */
	public Role findRoleById(String roleId);
	/**
	 * 更新角色
	 * @param r
	 */
	public void updateRole(Role r);
	/**
	 * 查询角色基本信息
	 * 查询角色已有的菜单信息
	 * @param roleId
	 * @return
	 */
	public Role unionFindRoleById(String roleId);
	/**
	 * 角色对应的菜单重新分配
	 * @param roleId
	 * @param mIds
	 */
	public void grantMenu2Role(String roleId, String[] mIds);
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findAllUser();
	/**
	 * 添加一个用户
	 * @param u
	 */
	public void addUser(User u);
	/**
	 * 根据用户id删除一个用户
	 * @param userId
	 */
	public void delOneUser(String userId);
	/**
	 * 根据用户名来查用户
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId);
	/**
	 * 更新用户信息
	 * @param u
	 */
	public void updateUser(User u);
	/**
	 * 查询角色基本信息
	 * 查询角色已有的菜单信息
	 * @param userId
	 * @return
	 */
	public User unionFindUserById(String userId);
	/**
	 * 建立用户与权限直接的关系
	 * @param uesrId
	 * @param rIds
	 */
	public void grantRole2User(String userId, String[] rIds);
	/**
	 * 删除Role_User之间的关系
	 * @param userId
	 */
	public void delRoleRelation(String userId);
	/**
	 * 删除菜单与Role的关系
	 * @param delRoleId
	 */
	public void delMenuRelation(String roleId);
	/**
	 * 删除Role_user表中的关系
	 * @param roleId
	 */
	public void delRoleRelationByRoleId(String roleId);
	/**
	 * 根据用户名密码查询用户
	 * @param username
	 * @param password
	 * @return	User
	 */
	public User findUserByUsernameAndPassword(String username, String password);
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
}
