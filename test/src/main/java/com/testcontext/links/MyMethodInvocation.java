package com.testcontext.links;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.List;

public class MyMethodInvocation implements MyPoint {

	protected final Object proxy;

	@Nullable
	protected final Object target;

	protected final Method method;

	protected Object[] arguments;


	private int currentInterceptorIndex = -1;

	protected final List<?> interceptorsAndDynamicMethodMatchers;

	public MyMethodInvocation(Object proxy, @Nullable Object target, Method method, @Nullable Object[] arguments, List<Object> advices) {
		this.proxy = proxy;
		this.target = target;
		this.method = method;
		this.arguments = arguments;
		this.interceptorsAndDynamicMethodMatchers = advices;
	}

	@Override
	public Object proceed() throws Throwable {
		if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
			return invokeJoinpoint();
		}
		Object interceptorOrInterceptionAdvice =
				this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
		return ((MyAdvice) interceptorOrInterceptionAdvice).invoke(this);
	}

	public Object invokeJoinpoint() throws Throwable {
		return this.method.invoke(target, arguments);
	}

}
