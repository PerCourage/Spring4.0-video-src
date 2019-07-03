package com.test.service;

public class SomServiceImpl implements ISomeService {
	public SomServiceImpl() {
		System.out.println("执行无参构造器");
	}

	@Override
	public void doSome() {
		System.out.println("执行some()方法");
	}

}
