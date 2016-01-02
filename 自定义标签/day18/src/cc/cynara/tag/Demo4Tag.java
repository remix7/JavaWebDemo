package cc.cynara.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo4Tag extends TagSupport {
	private int count;
	private int temp;

	public void setCount(int count) {
		this.count = count;
		this.temp = count;
	}
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() throws JspException {
		count--;
		if (count > 0) {
			return IterationTag.EVAL_BODY_AGAIN;
		}
		count = temp;
		return Tag.SKIP_BODY;
	}
}
