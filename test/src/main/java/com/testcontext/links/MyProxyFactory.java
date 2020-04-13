package com.testcontext.links;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MyProxyFactory<T> {

	private static ConcurrentMap targetCache = new ConcurrentHashMap();

	private final Class<T> mapperInterface;
	private List<Object> advices;
	private Object target;

	public MyProxyFactory(Class<T> mapperInterface, List<Object> advices, Object target) {
		this.mapperInterface = mapperInterface;
		this.advices = advices;
		this.target = target;
	}

	protected T newInstance(MyProxy<T> mapperProxy) {
		//用JDK自带的动态代理生成映射器
		return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
	}

	public T newInstance() {
		final MyProxy<T> mapperProxy = new MyProxy<T>(mapperInterface, advices,target);
		return newInstance(mapperProxy);
	}

}
