package com.testcontext.links;

public class MyBeforeAdvice implements MyAdvice {

	private String name;

	public MyBeforeAdvice(String name) {
		this.name = name;
	}
	@Override
	public Object invoke(MyMethodInvocation invocation) throws Throwable {
		System.out.println("before----->"+name);
		return invocation.proceed();
	}
}
