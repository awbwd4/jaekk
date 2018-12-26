package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {

	@Autowired
	private MemberDao memDao;
	private MemberPrinter memberPrinter;

	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	@Qualifier("sysout") //주입될 객체인 memberPrinter의 빈 객체가 appCtx에 두개가 존재함
	//따라서 qualifier값을 "sysout"으로 갖는 빈객체를 주입하도록 따로 설정해줌.
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	
	
	
	public void printMemberInfo(String email) {
		
		Member member =  memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터없음 \n");
			return;
		}
		
		memberPrinter.print(member);
		System.out.println();
	}
	
	
	
	
}
