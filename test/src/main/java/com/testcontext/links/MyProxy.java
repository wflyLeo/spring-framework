package com.testcontext.links;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyProxy<T> implements InvocationHandler {


	private final Class<T> mapperInterface;
	private List<Object> advices;
	private Object target;

	public MyProxy(Class<T> mapperInterface, List<Object> advices, Object target) {
		this.mapperInterface = mapperInterface;
		this.advices = advices;
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyMethodInvocation methodInvocation = new MyMethodInvocation(proxy, this.target, method, new Object[0], advices);
		return methodInvocation.proceed();
	}


}
