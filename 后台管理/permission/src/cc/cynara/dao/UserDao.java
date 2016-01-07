package cc.cynara.dao;

import java.util.List;

import cc.cynara.domain.User;

public interface UserDao {
	/**
	 * 查询出所有的用户
	 * @return list
	 */
	List<User> findAllUser();
	/**
	 * 添加一个用户
	 * @param u
	 */
	void addUser(User u);
	/**
	 * 根据用户id删除用户
	 * @param userId
	 */
	void delOneUser(String userId);
	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);
	/**
	 * 更新用户信息
	 * @param u
	 */
	void updateUser(User u);
	/**
	 * 查询角色基本信息
	 * 查询角色已有的菜单信息
	 * @param userId
	 * @return
	 */
	User unionFindUserById(String userId);
	/**
	 * 删除原表中的用户和权限的关系
	 * @param uesrId
	 */
	void delRoleRelation(String userId);
	/**
	 * 建立新的关系
	 * @param uesrId
	 * @param rIds
	 */
	void grantRole2User(String userId, String[] rIds);
	/**
	 * 删除Role_user表中的关系
	 * @param roleId
	 */
	void delRoleRelationByRoleId(String roleId);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByUsernameAndPassword(String username, String password);
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);


}
