package cc.cynara.example.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ForEachSimpleTag foreach1.jsp ecynara.tld共同组成类似forEach功能的方法   
 * @author REMIX-7
 *
 */
public class ForEachSimpleTag extends SimpleTagSupport {
	private List items;
	private String var;
	public void setItems(List items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		for(Object obj:items){
			pc.setAttribute(var, obj);
			getJspBody().invoke(null);
		}
	}
}
