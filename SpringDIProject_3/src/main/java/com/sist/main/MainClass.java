package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 	application-context.xml
 *  application-datasource.xml
 *  application-security.xml
 *  application-websocket.xml
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] xml= {"student-app.xml","member-app.xml","sawon-app.xml"};
		 * ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		 */
		ApplicationContext app=new ClassPathXmlApplicationContext("*-app.xml");
		
		System.out.println("===== member =====");
		Member m=(Member)app.getBean("mem");
		System.out.println("번호: "+m.getNo());
		System.out.println("이름: "+m.getName());
		System.out.println("성별: "+m.getSex());
		System.out.println("===== student =====");
		Student m1=(Student)app.getBean("std");
		System.out.println("번호: "+m1.getHakbun());
		System.out.println("이름: "+m1.getName());
		System.out.println("성별: "+m1.getSex());
		System.out.println("===== sawon =====");
		Sawon m2=(Sawon)app.getBean("sa");
		System.out.println("번호: "+m2.getSabun());
		System.out.println("이름: "+m2.getName());
		System.out.println("성별: "+m2.getSex());
	}

}
