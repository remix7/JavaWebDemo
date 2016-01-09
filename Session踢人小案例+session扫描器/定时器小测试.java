package cc.cynara.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerD {
	public static void main(String[] args) {
		
	
		Calendar c = Calendar.getInstance();
		c.set(2016, 0, 9, 11, 47, 00);
		Timer t = new Timer();
//		t.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("执行了");
//			}
//		}, c.getTime());
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("执行了");
			}
		}, 5*1000, 1*1000);
	}
}
