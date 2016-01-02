package cc.cynara.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Demo5Tag extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		String str = bodyContent.getString();
		try {
			pageContext.getOut().write(str.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	
	
}
