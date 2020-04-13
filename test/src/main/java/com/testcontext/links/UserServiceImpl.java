package com.testcontext.links;

public class UserServiceImpl implements UserService {

	@Override
	public String getName() {
		System.out.println("------------get user name--------");
		return "a123";
	}
}
