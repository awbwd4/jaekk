package spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}//생성자를 통해 의존 객체인 dao를 전달함. 직접 객체 생성ㄴㄴ
	
	//autowired로 의존 자동 주입을 하게 되면 디폴트 생성자를 하나 더 만들어줘야 함.
	public MemberRegisterService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
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
