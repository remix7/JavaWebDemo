package cc.cynara.bookstore.daotest;

import java.util.List;

import junit.framework.TestCase;
import cc.cynara.bookstore.dao.CategoryDao;
import cc.cynara.bookstore.dao.impl.CategoryDaoImpl;
import cc.cynara.bookstore.domain.Category;

public class CategoryDaoImplTest extends TestCase {
	private CategoryDao cd = new CategoryDaoImpl();
	public void testAddCategory() {
		Category c = new Category();
		c.setId("133");
		c.setName("niha");
		c.setDescription("wobuzd");
		cd.addCategory(c);
	}

	public void testDelCategory() {
	}

	public void testFindAllCategory() {
		List<Category> cs = cd.findAllCategory();
		for (Category category : cs) {
			System.out.println(category.getDescription());
		}
	}

	public void testFindCategoryById() {
		Category c = cd.findCategoryById("133");
		assertEquals(c.getName(), "niha");
	}

	public void testUpdateCategory() {
		Category c = new Category();
		c.setId("133");
		c.setName("你是猪吗");
		c.setDescription("ad");
		cd.updateCategory(c);
	}

}
