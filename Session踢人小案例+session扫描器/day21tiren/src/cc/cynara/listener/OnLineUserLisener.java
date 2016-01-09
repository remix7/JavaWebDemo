package cc.cynara.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cc.cynara.domain.User;
/**
 * 只要页面项session域中放东西都会执行add方法
 * 要的放User对象 标记还是user的
 * 找个地方存放起来  容器要求唯一 且页面能够访问的到
 * @author REMIX-7
 *
 */
public class OnLineUserLisener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		ServletContext sc = session.getServletContext();
		Object obj = session.getAttribute("user");
		if(obj!=null&&obj instanceof User){
			//保存到容器中
			Map<String, HttpSession> map  = (Map<String, HttpSession>) sc.getAttribute("users");
			if(map==null){
				map = new HashMap<String, HttpSession>();
				sc.setAttribute("users", map);
			}
			map.put(((User)obj).getUsername(), session);
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

}
