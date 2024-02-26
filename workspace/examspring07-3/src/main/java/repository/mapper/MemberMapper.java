package repository.mapper;

import java.util.List;
import examspring.Member;

public interface MemberMapper {

	public List<Member> selectAll();
	
	public Member selectOne(String memberid);
	
	public void insert(final Member member);
	
	public void update(Member member);

}
