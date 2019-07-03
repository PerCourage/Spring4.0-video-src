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
		//创建容器对象
		ISomeService service = new SomServiceImpl(); 
		service.doSome();
	}
	@Test
	public void test02(){
		//创建容器对象,加载Spring配置文件
		//会从类路径下查找配置文件
		//配置文件放在src目录下
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myservice"); 
		service.doSome();
	}
	@Test
	public void test03(){
		
		/**
		 *	创建容器对象
		 *  在应用根目录下查找配置文件
		 * 	将配置文件放在当前项目根路径
		 */
		ApplicationContext ac = new FileSystemXmlApplicationContext("applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myservice"); 
		service.doSome();
	}

	@Test
	public void test04(){
		//创建容器对象
		//在硬盘位置查找配置文件
		ApplicationContext ac = new FileSystemXmlApplicationContext("d:\applicationContext.xml");
		ISomeService service = (ISomeService) ac.getBean("myservice"); 
		service.doSome();
	}
	
	//ApplicationContext 与BeanFactory容器的区别
	/*	这两个容器对于其中Bean的创建时机不同
	 * 	1)ApplicationContext 容器，会在容器对象初始化时，将其中的所有Bean(对象)进行创建
	 * 		缺点：占用系统资源（内存、cpu等）
	 * 		优点：响应速度快
		2)BeanFactory容器中的对象，在容器初始化时不会被创建，而是在真正获取该对象时才被创建
			缺点：响应速度慢
			优点：不多占用系统资源
	*/
	
	@Test
	public void test05(){
		//创建容器对象
		BeanFactory bf=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ISomeService service = (ISomeService) bf.getBean("myservice"); 
		service.doSome();
	}
}
