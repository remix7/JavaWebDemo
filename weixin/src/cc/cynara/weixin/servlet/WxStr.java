package cc.cynara.weixin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cc.cynara.weixin.message.Text;


/**
 * @author haibing.xiao
 * @since jdk1.6
 * @version 1.0
 */
public class WxStr extends HttpServlet { 
	
	//token 和微信值一直
	public static final String TOKEN = "javaweb";
	@Override
	public void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = requset.getParameter("signature");
		String timestamp = requset.getParameter("timestamp");
		String nonce = requset.getParameter("nonce");
		String echostr = requset.getParameter("echostr");
		List<String> strList = new ArrayList<String>();
		strList.add(TOKEN);
		strList.add(timestamp);
		strList.add(nonce);
		Collections.sort(strList, new SpellComparator());
		String wxstr = strList.get(0)+strList.get(1)+strList.get(2);
		if (DigestUtils.sha1Hex(wxstr).equals(signature.trim())) {
			System.out.println("验证成功");
			response.getWriter().write(echostr);
		}else{
			System.out.println("验证失败");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String, String> xmls = parseXml(request, response);
			System.out.println(xmls.size());
			String flag = xmls.get("MsgType");
			if(flag.equals("text")){
				response.getWriter().write(SendMessage.realTextMessgae(xmls));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	public static Map<String, String> parseXml(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("run parseXml");
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		in.close();
		return map;
	}
	/** 
	 * 汉字拼音排序比较器 
	 */  
	class SpellComparator implements Comparator {
		public int compare(Object o1, Object o2) {
			try {
				// 取得比较对象的汉字编码，并将其转换成字符串
				String s1 = new String(o1.toString().getBytes("GB2312"),
						"ISO-8859-1");
				String s2 = new String(o2.toString().getBytes("GB2312"),
						"ISO-8859-1");
				// 运用String类的 compareTo（）方法对两对象进行比较
				return s1.compareTo(s2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
	}
}
