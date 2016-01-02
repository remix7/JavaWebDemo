package cc.cynara.simple.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo5SimpleTag extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		String content = sw.toString();
		PageContext pc = (PageContext)getJspContext();
		pc.getOut().write(content.toUpperCase());
		
	}

}
