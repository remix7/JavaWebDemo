package cc.cynara.bookstore.dao.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.cynara.bookstore.dao.CategoryDao;
import cc.cynara.bookstore.domain.Book;
import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.exception.DaoException;
import cc.cynara.bookstore.util.DBCPUtils;

public class CategoryDaoImpl implements CategoryDao {
	private QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
	public void addCategory(Category c) {
		try {
			qr.update("insert into category(id,name,description) values(?,?,?)", c.getId(),c.getName(),c.getDescription());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void delCategory(String categoryId) {
		try {
			Book b = null;
			b = qr.query("select * from book where category_id=?", new BeanHandler<Book>(Book.class), categoryId);
			System.out.println(b);
			b.setCategory_id("null");
			System.out.println(b);
			qr.update("update book set name=?,author=?,price=?,image=?,description=?,id=? where category_id=?",b.getName(),b.getAuthor(),b.getPrice(),b.getImage(),b.getDescription(),b.getCategory_id(),b.getId(),"null");
			qr.update("delete from category where id=?",categoryId);
			
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public List<Category> findAllCategory() {
		try {
			List<Category> cs = qr.query("select * from category", new BeanListHandler<Category>(Category.class));
			return cs;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Category findCategoryById(String categoryId) {
		try {
			Category c = qr.query("select * from category where id=?", new BeanHandler<Category>(Category.class), categoryId);
			return c;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void updateCategory(Category c) {
		try {
			qr.update("update category set name=?,description=? where id=?", c.getName(),c.getDescription(),c.getId());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
