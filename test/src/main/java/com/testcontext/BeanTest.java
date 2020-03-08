package com.testcontext;

import org.springframework.stereotype.Component;

@Component
public class BeanTest {

	private String name = "111";


	public void fun1(String name) {
		System.out.println("fun1");
	}


	public void fun2(String name, Integer age) {
		System.out.println("fun2");
	}


	public void fun3() {
		System.out.println("fun3");
	}

}
