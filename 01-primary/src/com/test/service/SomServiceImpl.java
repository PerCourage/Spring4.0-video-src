package com.test.service;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

public class SomServiceImpl implements ISomeService {

	private int a=5;
	//��̬�����
	//һ��û�г�Ա�����Ķ����ڶ��ڴ���ռ��8���ֽ�
	//Object obj=new Object();  
	/*{
		System.out.println("ִ�ж�̬�����a="+a);
	}*/
	public SomServiceImpl() {
		System.out.println("ִ���޲ι�����");
	}

	@Override
	public void doSome() {
		System.out.println("ִ��some()����");
	}

}
