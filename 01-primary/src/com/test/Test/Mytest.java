package com.test.Test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.test.service.ISomeService;
import com.test.service.SomServiceImpl;

public class Mytest {
	@Test
	public void test01(){
		//������������
		ISomeService service = new SomServiceImpl(); 
		service.doSome();
	}
	@Test
	public void test02(){
		//������������,����Spring�����ļ�
		//�����·���²��������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myservice"); 
		service.doSome();
	}
	@Test
	public void test03(){
		//������������
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myservice"); 
		service.doSome();
	}
	
	//ApplicationContext ��BeanFactory����������
	/*	������������������Bean�Ĵ���ʱ����ͬ
	 * 	1)ApplicationContext �������������������ʼ��ʱ�������е�����Bean(����)���д���
	 * 		ȱ�㣺ռ��ϵͳ��Դ���ڴ桢cpu�ȣ�
	 * 		�ŵ㣺��Ӧ�ٶȿ�
		2)BeanFactory�����еĶ�����������ʼ��ʱ���ᱻ������������������ȡ�ö���ʱ�ű�����
			ȱ�㣺��Ӧ�ٶ���
			�ŵ㣺����ռ��ϵͳ��Դ
	*/
	
	
	
	
	
	@Test
	public void test05(){
		//������������
		BeanFactory bf=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ISomeService service = (ISomeService) bf.getBean("myservice"); 
		service.doSome();
	}
}
