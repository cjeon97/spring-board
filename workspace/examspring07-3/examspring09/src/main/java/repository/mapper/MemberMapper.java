package repository.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import repository.Member;

@Mapper
public interface MemberMapper {
	// 전체 조회
	public List<Member> selectAll();

	// 멤버 검색
	public Member selectOne(String memberid);

	// 멤버 삽입
	public void insert(Member member);

	// 멤버 수정	
	public void update(Member member);
	
	// 멤버 탈퇴
	public void delete(Member member);
	
	// 회원검색(날짜)
	public List<Member> selectRegdate(Map<String, LocalDateTime> map);
	
	public Member selectByNo(Long no);
}
