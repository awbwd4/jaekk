package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;
import spring.Client2;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:springconf.xml");
		
		Client client1 = ctx.getBean("client", Client.class);
		Client client2= ctx.getBean("client", Client.class);
		//객체 생성+프로퍼티 설정+초기화 메서드 실행
		
		
		System.out.println(client1 == client2);
		
		/*
		Client2 cl2 = ctx.getBean("client2", Client2.class);
		cl2.send();*/
		
		
		ctx.close();//destroy 메서드 실행+종료
		
		
	}
	
	
	
	
}
