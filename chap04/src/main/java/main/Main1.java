package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main1 {

	
	public static void main(String[] args) {
		
		//appCtx2를 사용하면  MemberInfoPrinter 클래스의 @Autowired가 적용된 setPrinter() 메서드에 
		// MemberPrinter 타입의 두 빈 객체 중 어떤 객체를 주입해야 할지 모르기 때문에 익셉션이 발생한다.
		
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx2.xml");
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
