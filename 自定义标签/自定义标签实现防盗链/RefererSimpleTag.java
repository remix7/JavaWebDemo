package cc.cynara.example.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��ֹ����С�̳� 
 * RefererSimpleTag example/ad.jsp index.jsp ecynara.tld  �������ֱ�ӷ�����վ����
 * �ӱ�ĵط������ӹ�����   ��ֱ����ʾ���ҳ��
 * @author REMIX-7
 *
 */
public class RefererSimpleTag extends SimpleTagSupport {
	private String site;//����ֱ�ӷ��ʵ���վ
	private String adpage;//�����վ
	
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
		//�õ������referer ͷ  
		String refererValue = hsr.getHeader("referer");
		//�������NUll���Ҳ�����siet��ͷ�� �����
		if(refererValue!=null){
			if(!refererValue.startsWith(site)){
				response.sendRedirect(hsr.getContextPath()+adpage);
			}
		}
	}
}
