package com.sist.main3;

import com.sist.main2.ApplicationContext;
import com.sist.main2.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");	
		Member m=(Member)app.getBean("mem");
		System.out.println("번호: "+m.getNo());
		System.out.println("이름: "+m.getHman().getName());
		System.out.println("성별: "+m.getHman().getSex());
		System.out.println("주소: "+m.getHman().getAddress());
		System.out.println("전화: "+m.getHman().getPhone());
		
		Student n=(Student)app.getBean("std");
		System.out.println("번호: "+n.getHakbun());
		System.out.println("이름: "+n.getHman().getName());
		System.out.println("성별: "+n.getHman().getSex());
		System.out.println("주소: "+n.getHman().getAddress());
		System.out.println("전화: "+n.getHman().getPhone());
	}

}
