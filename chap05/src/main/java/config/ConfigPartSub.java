package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;

public class ConfigPartSub {

	@Autowired
	private MemberDao memberDao;

	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
	
	
}
