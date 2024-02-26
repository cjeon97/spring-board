package examspring01;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static long sequence = 1;
	private Map<String, Member> database = new HashMap<>();
	
	public Member selectOne(String memberid) {
		return database.get(memberid);
	}
	
	public void insert(Member member) {
		member.setNumber(sequence++);
		database.put(member.getMemberid(), member);
	}
	
	public void update(Member member) {
		database.put(member.getMemberid(), member);
	}
	
}
