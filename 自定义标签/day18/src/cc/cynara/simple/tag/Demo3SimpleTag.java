package cc.cynara.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3SimpleTag extends SimpleTagSupport {
	@Override
	/**
	 * �״��쳣���ǩ��������ݲ�ִ��
	 */
	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
}
