package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaConfig;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
	
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
	
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("asdf");
		regReq.setName("adsfadsfadsfasdf");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.register(regReq);
		
		infoPrinter.printMemberInfo("asdf");
	
	
	
	
	}
	
	

}
