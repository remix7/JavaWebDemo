package cc.cynara.example.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ChooseSimpleTag whenSimpleTag OtherWiseSimpleTag ifelse.jsp  ecynara.tld
 * 一起实现嵌套标签  当grade 为A 是为优秀 其他情况为一般一般   类似于if else
 * @author REMIX-7
 *
 */
public class ChooseSimpleTag extends SimpleTagSupport {

	protected boolean flag;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void doTag() throws JspException, IOException {
			getJspBody().invoke(null);
	}
}
