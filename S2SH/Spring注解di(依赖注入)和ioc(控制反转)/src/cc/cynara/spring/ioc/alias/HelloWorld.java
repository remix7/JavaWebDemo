package cc.cynara.spring.ioc.alias;

public class HelloWorld {
	//spring创建对象的方式  默认是h调用默认的构造方法
	public HelloWorld(){
		System.out.println("new ins");
	}
	public void hello(){
		System.out.println("hello");
	}
}
