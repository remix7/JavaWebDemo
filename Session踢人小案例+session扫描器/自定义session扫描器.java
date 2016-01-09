package cc.cynara.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//自定义session扫描器 如一个session超过一分钟没有使用  就主动干掉
public class HttpSessionScanerListener implements HttpSessionListener ,ServletContextListener {
	private List<HttpSession> sessions = new ArrayList<HttpSession>();//存放session对象
	private Object lock = new Object();//新建一个锁 在session遍历和创建的时候互相等待
	//拿到回话session对象
	public void sessionCreated(HttpSessionEvent se) {
		synchronized (lock) {
			HttpSession session = se.getSession();
			sessions.add(session);
			System.out.println(session + "创建");
		}
	}	
	//销毁session时执行
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session+"销毁");
	}
	//应用销毁
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	//应用创建  启动定时器
	public void contextInitialized(ServletContextEvent sce) {
		Timer t = new Timer();
		t.schedule(new SessionScanTask(sessions,lock),0, 1*20*1000);
	}

}
class SessionScanTask extends TimerTask{
	private List<HttpSession> sessions;
	private Object lock;
	public SessionScanTask(List<HttpSession> sessions,Object lock){
		this.sessions = sessions;
		this.lock = lock;
	}
	//扫描session对象
	public void run() {
		synchronized (lock) {
			ListIterator<HttpSession> it = sessions.listIterator();
			while (it.hasNext()) {
				HttpSession session = it.next();
				if ((System.currentTimeMillis() - session.getLastAccessedTime()) > 60 * 1000) {
					session.invalidate();
					it.remove();
				}
			}
			//			for (HttpSession session:sessions) {
			//				if((System.currentTimeMillis()-session.getLastAccessedTime())>60*1000){
			//					session.invalidate();
			//					sessions.remove(session);
			//				}
			//			}
		}
	}
	
}



