package cc.cynara.spring.mvc.exception.aspect;

public class MyException {
	public void myException(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
