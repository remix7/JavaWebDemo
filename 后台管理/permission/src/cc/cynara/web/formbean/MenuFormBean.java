package cc.cynara.web.formbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuFormBean {
	private String name;
	private String uri;
	private String description;
	Map<String, String> errors = new HashMap<String, String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
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
	public boolean validate(){
		if(name==null||"".equals(name)){
			errors.put("name", "名字为必填项!");
		}
		if(uri==null||"".equals(uri)){
			errors.put("uri", "URI为必填项!");
		}
		if(description==null||"".equals(description)){
			errors.put("description", "描述为必填项!");
		}
		return errors.isEmpty();
	}
	
}
