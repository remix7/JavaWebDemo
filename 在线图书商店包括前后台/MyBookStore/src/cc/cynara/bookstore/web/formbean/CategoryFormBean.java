package cc.cynara.bookstore.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class CategoryFormBean {
	private String name;
	private String description;
	Map<String, String> errors = new HashMap<String, String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean invated(){
		if(name==null||"".equals(name)){
			errors.put("name", "分类名称是必填项！");
		}
		return errors.isEmpty();
	}
}
