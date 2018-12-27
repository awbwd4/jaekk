package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Client;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:springconf.xml");
		
		Client client = ctx.getBean("client", Client.class);
		//객체 생성+프로퍼티 설정+초기화 메서드 실행
		
		
		client.send();
		
		
		
		ctx.close();//destroy 메서드 실행+종료
		
		
	}
	
	
	
	
}
