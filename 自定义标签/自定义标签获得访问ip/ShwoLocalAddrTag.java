package cc.cynara.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
/*
pageContext 是默认存在的对象

*/
public class ShwoLocalAddrTag extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		String id = pageContext.getRequest().getLocalAddr();
  		try {
			pageContext.getOut().write(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
