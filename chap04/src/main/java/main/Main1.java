package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main1 {

	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		
		regReq.setEmail("asdf");
		regReq.setName("adsfadsfadsfasdf");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.register(regReq);
		
		infoPrinter.printMemberInfo("asdf");
		
		
		
	}
	
	
	
	
}
