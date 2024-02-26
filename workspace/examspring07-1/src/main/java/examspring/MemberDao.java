package examspring;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectOne(String memberid) {
		StringBuffer sql = new StringBuffer();
		sql.append("select \"NO\", \"MEMBER_ID\", \"MEMBER_PW\", \"NICK\", \"REGDATE\"");
		sql.append(" from \"MEMBER\" where \"MEMBER_ID\"=?");
		System.out.println("sql:" +sql.toString());
		
		//Member member = jdbcTemplate.queryForObject(sql.toString(), Member.class, memberid);
		List<Member> result = jdbcTemplate.query(sql.toString(), new MemberRowMapper(), memberid);
		
		return result.isEmpty() ? null : result.get(0);
	}
	
//	public void insert(Member member) {
//		String sql = "insert into \"MEMBER\""
//				+ " (\"NO\", \"MEMBER_ID\", \"MEMBER_PW\", \"NICK\", \"REGDATE\")"
//				+ " values(\"SEQ_MEMBER\".NEXTVAL, ?, ?, ?, sysdate)";
//		int result = jdbcTemplate.update(
//				sql,
//				member.getMemberid(),
//				member.getMemberpw(),
//				member.getNick());
//		System.out.println(result + "행 삽입 완료");	
//	}
	
//	public void insert(Member member) {
//		String sql = "insert into \"MEMBER\""
//				+ " (\"NO\", \"MEMBER_ID\", \"MEMBER_PW\", \"NICK\", \"REGDATE\")"
//				+ " values(\"SEQ_MEMBER\".NEXTVAL, ?, ?, ?, sysdate)";
//		int result = jdbcTemplate.update(
//				new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//						PreparedStatement pstmt = con.prepareStatement(sql);
//						pstmt.setString(1, member.getMemberid());
//						pstmt.setString(2, member.getMemberpw());
//						pstmt.setString(3, member.getNick());
//						return pstmt;
//					}
//				});
//		System.out.println(result + "행 삽입 완료");	
//	}
	
	@Transactional
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into \"MEMBER\""
				+ " (\"NO\", \"MEMBER_ID\", \"MEMBER_PW\", \"NICK\", \"REGDATE\")"
				+ " values(\"SEQ_MEMBER\".NEXTVAL, ?, ?, ?, sysdate)";
		int result = jdbcTemplate.update(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"NO"});
						pstmt.setString(1, member.getMemberid());
						pstmt.setString(2, member.getMemberpw());
						pstmt.setString(3, member.getNick());
						return pstmt;
					}
				}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setNo(keyValue.longValue());
		System.out.println("저장된 키:" + keyValue);
		System.out.println(result + "행 삽입 완료");
	}
	
	@Transactional
	public void update(Member member) {
		String sql = "update \"MEMBER\" set \"MEMBER_PW\"=? where \"MEMBER_ID\"=?";

		int result = jdbcTemplate.update(
				sql,
				member.getMemberpw(),
				member.getMemberid());
				System.out.println(result + "행 수정 완료");	
	}
	
	public List<Member> selectAll() {
		String sql = "select * from \"MEMBER\" order by \"NO\" asc";
		List<Member> result = jdbcTemplate.query(sql, new MemberRowMapper());
//		List<Member> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
		return result;
	}

	
}
