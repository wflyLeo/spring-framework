package com.testcontext.links;

import java.util.ArrayList;
import java.util.List;

public class AdviceTest {

	public static void main(String[] args) {
		List advices = new ArrayList<>();
		advices.add(new MyAfterAdvice("after2"));
		advices.add(new MyBeforeAdvice("before2"));
		advices.add(new MyAfterAdvice("after1"));
		advices.add(new MyBeforeAdvice("before1"));
		MyProxyFactory factory = new MyProxyFactory(UserService.class, advices, new UserServiceImpl());
		UserService userService = (UserService) factory.newInstance();
		System.out.println(userService.getName());
	}

}
