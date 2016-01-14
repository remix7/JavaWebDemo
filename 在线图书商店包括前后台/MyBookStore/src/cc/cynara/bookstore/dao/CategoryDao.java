package cc.cynara.bookstore.dao;

import java.util.List;

import cc.cynara.bookstore.domain.Category;

public interface CategoryDao {
	/**
	 * 添加分类
	 * @param c
	 */
	void addCategory(Category c);
	/**
	 * 查询所有分类
	 * @return 返回所有分类
	 */
	List<Category> findAllCategory();
	/**
	 * 修改分类
	 * @param c
	 */
	void updateCategory(Category c);
	/**
	 * 根据id删除分类
	 * @param categoryId
	 */
	void delCategory(String categoryId);
	/**
	 * 根据id查询分类
	 * @param categoryId
	 * @return 没有则返回null
	 */
	Category findCategoryById(String categoryId);
}
