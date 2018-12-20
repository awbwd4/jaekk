package chap03;

import java.util.Date;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}//생성자를 통해 의존 객체인 dao를 전달함. 직접 객체 생성ㄴㄴ
	
	public void register(RegisterRequest req) {
		
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email" + req.getEmail());
		}
		
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(),
				new Date());
		
		memberDao.insert(newMember);
		
		
	}
	
	
	
}
