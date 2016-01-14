package cc.cynara.bookstore.util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class OrdersId {
	public static String getOrderId(){
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String str = df.format(now)+System.currentTimeMillis();
		return str;
	}
}
