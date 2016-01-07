package cc.cynara.dao;

import java.util.List;

import cc.cynara.domain.Role;
import cc.cynara.domain.User;

public interface RoelDao {
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
	public void delOneRole(String roleId);
	/**
	 * 查询出一个角色
	 * @param roleId
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
	 * 删除角色中对应的原有关系
	 * @param roleId
	 */
	public void delMenuRelation(String roleId);
	

}
