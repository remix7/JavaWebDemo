package cc.cynara.simple.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo2SimpleTag extends SimpleTagSupport {
	@Override
	/**
	 * 若此方法中没有执行任何代码 则标签中的也不执行
	 */
	public void doTag() throws JspException, IOException {
//		//获取主体内容
//		JspFragment jf = getJspBody();
//		PageContext pc = (PageContext)getJspContext();
//		JspWriter out = pc.getOut();
//		jf.invoke(out);///把主体内容输入到指定的流中
		
		getJspBody().invoke(null);//作用与上面代码相同
	}
}
