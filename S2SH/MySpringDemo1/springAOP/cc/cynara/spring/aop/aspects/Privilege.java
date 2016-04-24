package cc.cynara.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class Privilege {
	private String pri;

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}
	public void showPrivilege(ProceedingJoinPoint joinPoint) throws Throwable{
		if(this.pri.equals("admin")){
			joinPoint.proceed();
		}else{
			System.out.println("没有权限！");
		}
	}
}
