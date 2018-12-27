package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberRegisterService;


@Configuration
@Import(ConfigPartSub.class)
/*@Import({ConfigPartSub1.class, ConfigPartSub2.class})
설정 클래스가 여러개면 이런식으로도 가능함.*/
public class ConfigPartMain {

	
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
	
	
}
