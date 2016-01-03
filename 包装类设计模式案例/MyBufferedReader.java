package cc.cynara.buffered;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 包装设计模式的实现方式
 编写一个类，实现其实现的接口
 定义一个变量记住被包装对象的引用
 定义构造方法 注入被包装对象的引用
 对于要改写的方法 改写之
 对不要改写的方法  调用原有对象的对应方法
 * 
 对于一个包装类没有实现接口的操作步骤
 编写一个类，继承要包装的类
 定义一个变量记住被包装对象的引用
 定义构造方法 注入被包装对象的引用
 对于要改写的方法 改写之
 * @author REMIX-7
 *
 */
public class MyBufferedReader extends BufferedReader{
//	private BufferedReader br ;
//	private int count = 1;
//	private MyBufferedReader(BufferedReader br){
//		super(br);
//		this.br = br;
//	}
//	@Override
//	//拿到其原有对象的对应方法 判断返回值再包装
//	public String readLine() throws IOException {
//		String data = br.readLine();
//		if(data == null){
//			return data;
//		}
//		return count+++data;
//	}
	private int count = 1;
	public MyBufferedReader(BufferedReader br){
		super(br);
	}
	@Override
	//拿到其原有对象的对应方法 判断返回值再包装
	public String readLine() throws IOException {
		String data = super.readLine();
		if(data == null){
			return data;
		}
		return count+++data;
	}
}
