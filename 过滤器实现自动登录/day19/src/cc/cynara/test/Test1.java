package cc.cynara.test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class Test1 {
	@Test//读取msg文件包中的值
	public void test1(){
		//默认是读取本地的消息
		ResourceBundle rb = ResourceBundle.getBundle("cc.cynara.resources.msg");
		String str = rb.getString("hello");
		System.out.println(str);
	}
	@Test//读取指定msg文件包中的值
	public void test2(){
		//默认是读取本地的消息
		Locale locale = Locale.US;
		ResourceBundle rb = ResourceBundle.getBundle("cc.cynara.resources.msg",locale);
		String str = rb.getString("hello");
		System.out.println(str);
	}
}
