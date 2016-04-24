package cc.cynara.spring.jdbc.transaction.exception;

public class MyException {
	public void myException(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
