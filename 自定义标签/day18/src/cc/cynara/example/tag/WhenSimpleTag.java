package cc.cynara.example.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenSimpleTag extends SimpleTagSupport {
	
	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			getJspBody().invoke(null);
			ChooseSimpleTag parent = (ChooseSimpleTag)getParent();
			parent.setFlag(true);
		}
		
	}
}	
