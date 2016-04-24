package cc.cynara.proxy;

public class Transaction {
	public void beginTransaction(){
		System.out.println("开启事物");
	}
	public void commit(){
		System.out.println("提交事物");
	}
}
