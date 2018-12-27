package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;
@Configuration
@Scope("prototype")
public class JavaConfig {

	
	//xml대신 자바로 설정할 경우 이렇게 초기화와 종료 메소드를 실행  할 수 있음.
	@Bean(initMethod = "connect", destroyMethod="close")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		return client2;
	}
	
	
	
	
}
