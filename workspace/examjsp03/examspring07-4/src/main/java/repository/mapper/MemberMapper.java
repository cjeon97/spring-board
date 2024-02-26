package repository.mapper;

import java.util.List;

import examspring.Member;

public interface MemberMapper {
	// 전체 조회
	public List<Member> selectAll();

	// 멤버 검색
	public Member selectOne(String memberid);

	// 멤버 삽입
	public void insert(Member member);

	// 멤버 수정
	public void update(Member member);
}
