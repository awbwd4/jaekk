package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import chap07.Calculator;
import chap07.ImplCalculator;

public class MainXmlPojo {

	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		Calculator implCal = ctx.getBean("implCal", Calculator.class);
		long fiveFact1 = implCal.factorial(5);
		System.out.println("implCal.factorial(5) = "+fiveFact1);
		
		
		
	}
	
	
	
}
