package com.testcontext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		BeanTest beanTest = app.getBean(BeanTest.class);
		beanTest.fun1("name1");
		BeanTest beanTest1 = app.getBean(BeanTest.class);
		System.out.println(beanTest == beanTest1);
	}
}
