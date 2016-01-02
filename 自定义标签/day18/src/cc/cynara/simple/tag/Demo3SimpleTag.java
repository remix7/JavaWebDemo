package cc.cynara.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3SimpleTag extends SimpleTagSupport {
	@Override
	/**
	 * 抛此异常则标签后面的内容不执行
	 */
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
}
