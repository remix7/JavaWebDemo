package cc.cynara.example.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 防止倒链小教程 
 * RefererSimpleTag example/ad.jsp index.jsp ecynara.tld  如果不是直接访问网站而是
 * 从别的地方超链接过来的   就直接显示广告页面
 * @author REMIX-7
 *
 */
public class RefererSimpleTag extends SimpleTagSupport {
	private String site;//允许直接访问的网站
	private String adpage;//广告网站
	
	public void setSite(String site) {
		this.site = site;
	}

	public void setAdpage(String adpage) {
		this.adpage = adpage;
	}

	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		ServletRequest req = pc.getRequest();
		HttpServletRequest hsr = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)pc.getResponse();
		//得到请求的referer 头  
		String refererValue = hsr.getHeader("referer");
		//如果不是NUll并且不是以siet开头的 看广告
		if(refererValue!=null){
			if(!refererValue.startsWith(site)){
				response.sendRedirect(hsr.getContextPath()+adpage);
			}
		}
	}
}
