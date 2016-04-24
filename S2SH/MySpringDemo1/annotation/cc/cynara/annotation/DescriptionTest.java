package cc.cynara.annotation;

import java.lang.reflect.Method;

import org.junit.Test;


public class DescriptionTest {
	@Test
	public void test(){
		Class class1 = Description.class;
		if(class1.isAnnotationPresent(CYNARA_ANN.class)){
			CYNARA_ANN ann = (CYNARA_ANN)class1.getAnnotation(CYNARA_ANN.class);
			if(ann.value().contains("我不")){
				System.out.println("nimeid ");
			}
		}
		Method[] methods = class1.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(CYNARA_METHOD.class)){
				CYNARA_METHOD method2 = (CYNARA_METHOD)method.getAnnotation(CYNARA_METHOD.class);
				if(method2.name().contains("o")){
					System.out.println("548");
				}
			}
		}
	}
}	
