package cc.cynara.example.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 改进方式可以适合list set map 和数组
 * ForEach2SimpleTag foreach2.jsp ecynara.tld
 * @author REMIX-7
 *
 */
public class ForEach2SimpleTag extends SimpleTagSupport {
	private Object items;
	private String var;
	private Collection collection;
	public void setItems(Object items) {
		if(items instanceof List){
			collection = (List)items;
		}else
		if(items instanceof Set){
			collection = (Set)items;
		}else
		if(items instanceof Map){
			collection = ((Map)items).entrySet();
		}else
		if(items.getClass().isArray()){
			collection = new ArrayList();
			int lenth = Array.getLength(items);
			for(int i=0;i<lenth;i++){
				collection.add(Array.get(items, i));
			}
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		for(Object obj:collection){
			pc.setAttribute(var, obj);
			getJspBody().invoke(null);
		}
	}
}
