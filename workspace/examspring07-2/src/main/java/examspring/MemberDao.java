package examspring;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

public class MemberDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Member> selectAll() {
		//쿼리문이 있는곳의 이름을 써주면 된다
		//memberMapper - namespace of mapper. selectAll - select id
		return sqlSessionTemplate.selectList("memberMapper.selectAll");
	}
	
	public Member selectOne(String memberid) {
		return sqlSessionTemplate.selectOne("memberMapper.selectOne", memberid);
	}
	
	
	@Transactional
	public void insert(final Member member) {
		sqlSessionTemplate.insert("memberMapper.insert", member);
	}
	
	@Transactional
	public void update(Member member) {
		sqlSessionTemplate.update("memberMapper.update", member);
	}
	
	@Transactional
	public void updateMap(String memberpw, String memberid) {
		Map<String, String> param = new HashMap<>();
		param.put("pw", memberpw);
		param.put("id", memberid);
		sqlSessionTemplate.update("memberMapper.updateMap", param);
	}

	
}
