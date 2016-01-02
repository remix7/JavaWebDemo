package cc.cynara.example.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiesSimpleTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		ChooseSimpleTag parent = (ChooseSimpleTag)getParent();
		if(!parent.isFlag()){
			getJspBody().invoke(null);
		}
		
	}
}
