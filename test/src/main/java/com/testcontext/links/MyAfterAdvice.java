package com.testcontext.links;

public class MyAfterAdvice implements MyAdvice {

	private String name;

	public MyAfterAdvice(String name) {
		this.name = name;
	}

	@Override
	public Object invoke(MyMethodInvocation invocation) throws Throwable {
		Object result = invocation.proceed();
		System.out.println("after------------>" + name);
		return result;
	}
}
