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
	 * ���˷�����û��ִ���κδ��� ���ǩ�е�Ҳ��ִ��
	 */
	public void doTag() throws JspException, IOException {
//		//��ȡ��������
//		JspFragment jf = getJspBody();
//		PageContext pc = (PageContext)getJspContext();
//		JspWriter out = pc.getOut();
//		jf.invoke(out);///�������������뵽ָ��������
		
		getJspBody().invoke(null);//���������������ͬ
	}
}
