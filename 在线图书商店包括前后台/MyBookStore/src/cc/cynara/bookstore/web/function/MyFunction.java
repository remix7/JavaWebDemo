package cc.cynara.bookstore.web.function;

import cc.cynara.bookstore.domain.Category;
import cc.cynara.bookstore.service.BusnessService;
import cc.cynara.bookstore.service.impl.BusnessServiceImpl;

public class MyFunction {
	
	private static BusnessService s = new BusnessServiceImpl();
	public static String getCategoruName(String categoryId){
		Category c = s.findCategoryById(categoryId);
		if(c!=null){
			return c.getName();
		}
		return "";
	}
	
}
