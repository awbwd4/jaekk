package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;


//자바 코드 설정에서는 @bean 어노테이션과 메소드 이름을 이용해서 스프링 컨테이너가 사용할
//빈 객체를 설정한다.
@Configuration
public class JavaConfig {

	
	
	@Bean
	public MemberDao memberDao() {//메서드 이름 : 식별자
		//즉, 이 빈객체의 이름 : memberDao
		return new MemberDao();//이렇게 리턴한 객체를 빈 객체로 사용한다.
		
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
		//직접 의존 객체 주입
		//xml dptjdml ref와 같음
		//<constructor-arg ref="memberDao"> 이거랑 같음
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
	
	

}
