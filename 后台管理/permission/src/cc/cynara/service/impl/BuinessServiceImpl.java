package cc.cynara.service.impl;

import java.util.List;
import java.util.UUID;

import cc.cynara.dao.MenuDao;
import cc.cynara.dao.RoelDao;
import cc.cynara.dao.UserDao;
import cc.cynara.dao.impl.MenuDaoImpl;
import cc.cynara.dao.impl.RoleDaoImpl;
import cc.cynara.dao.impl.UserDaoImpl;
import cc.cynara.domain.Menu;
import cc.cynara.domain.Role;
import cc.cynara.domain.User;
import cc.cynara.service.BuinessService;

public class BuinessServiceImpl implements BuinessService {
	private MenuDao md = new MenuDaoImpl();
	private RoelDao rd = new RoleDaoImpl();
	private UserDao ud = new UserDaoImpl();
	public List<Menu> FindAllMenu() {
		return md.FindAllMenu();
	}

	public void addMenu(Menu m) {
		m.setId(UUID.randomUUID().toString());
		md.addMenu(m);
	}

	public void deleteMenu(String menuId) {
		md.deleteMenu(menuId);
	}

	public Menu findMenuById(String menuId) {
		return md.findMenuById(menuId);
	}

	public void updateMenu(Menu m) {
		md.updateMenu(m);
	}

	public List<Role> findAllRole() {
		return rd.findAllRole();
	}

	public void addRole(Role r) {
		r.setId(UUID.randomUUID().toString());
		rd.addRole(r);
	}

	public void delOneRole(String delRoleId) {
		rd.delOneRole(delRoleId);
	}

	public Role findRoleById(String roleId) {
		return rd.findRoleById(roleId);
	}

	public void updateRole(Role r) {
		rd.updateRole(r);
	}

	public Role unionFindRoleById(String roleId) {
		return rd.unionFindRoleById(roleId);
	}

	public void grantMenu2Role(String roleId, String[] mIds) {
		rd.delMenuRelation(roleId);//删除角色中对应的原有关系
		rd.grantMenu2Role(roleId, mIds);//建立新的关系
	}

	public List<User> findAllUser() {
		return ud.findAllUser();
	}

	public void addUser(User u) {
		u.setId(UUID.randomUUID().toString());
		ud.addUser(u);
	}

	public void delOneUser(String userId) {
		ud.delOneUser(userId);
	}

	public User findUserById(String userId) {
		return ud.findUserById(userId);
	}

	public void updateUser(User u) {
		ud.updateUser(u);
	}

	public User unionFindUserById(String userId) {
		return ud.unionFindUserById(userId);
	}

	public void grantRole2User(String userId, String[] rIds) {
		ud.delRoleRelation(userId);//删除角色中对应的原有关系
		ud.grantRole2User(userId, rIds);//建立新的关系
	}

	public void delRoleRelation(String userId) {
		ud.delRoleRelation(userId);
	}

	public void delMenuRelation(String roleId) {
		rd.delMenuRelation(roleId);
	}

	public void delRoleRelationByRoleId(String roleId) {
		ud.delRoleRelationByRoleId(roleId);
	}

	public User findUserByUsernameAndPassword(String username, String password) {
		return ud.findUserByUsernameAndPassword(username, password);
	}

	public User findUserByUsername(String username) {
		return ud.findUserByUsername(username);
	}

	

}
