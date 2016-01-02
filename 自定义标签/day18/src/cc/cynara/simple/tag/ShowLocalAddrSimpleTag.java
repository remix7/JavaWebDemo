package cc.cynara.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowLocalAddrSimpleTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		String ip = pc.getRequest().getRemoteAddr();
		pc.getOut().write(ip);
	}
}
