package assembler;

import chap03.ChangePasswordService;
import chap03.MemberDao;
import chap03.MemberRegisterService;

public class Assembler {
	
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService changePwdSvc;
	
	
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		changePwdSvc = new ChangePasswordService(memberDao);
	}



	public MemberDao getMemberDao() {
		return memberDao;
	}



	public MemberRegisterService getRegSvc() {
		return regSvc;
	}



	public ChangePasswordService getChangePwdSvc() {
		return changePwdSvc;
	}
	

	
	
	
	
	
	
	
}
