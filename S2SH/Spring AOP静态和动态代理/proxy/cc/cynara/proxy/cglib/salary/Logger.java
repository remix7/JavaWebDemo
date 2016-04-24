package cc.cynara.proxy.cglib.salary;

public class Logger implements Interceptor {

	public void interceptor() {
		System.out.println("Logging");
	}
}	
