package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;



@Configuration
public class ConfigPart2 {

	/*@Autowired
	private MemberDao memberDao;
	//infoPrinter 메소드에 주입하기 위해 빈객체를 필드로 생성
	//MemberDao 타입의 빈은 ConfigPart1 클래스에 정의되어 있음.
	//따라서 ConfigPart2에서는 메서드를 호출하는 방식으로는 접근할 수 없다.
	//주입에 필요한 객체를 위처럼 필드로 주입을 받은 뒤에 이것을 주입할 객체로 활용함.
	*/
	
	
	@Autowired
	private ConfigPart1 configPart1;
	
	/*@configuration 어노테이션을 붙여서 스프링 빈객체가 되는 클래스라도, 
	필요하다면 다른 빈 객체를 의존 주입 받을 수 있다.*/
	
	
	
	
	
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(configPart1.memberDao());
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
	
	
	
	
	
}
