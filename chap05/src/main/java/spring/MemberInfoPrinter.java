package spring;

public class MemberInfoPrinter {

	private MemberDao memDao;
	private MemberPrinter memberPrinter;

	
	
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("member register service 주입 : "+memberDao);
		this.memDao = memberDao;
	}
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
