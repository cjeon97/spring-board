package examspring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member(
				rs.getString(2), //"MEMBER_ID"
				rs.getString("MEMBER_PW"), //3
				rs.getString("NICK"), //4
				LocalDateTime.ofInstant(
						new Date(rs.getDate("REGDATE").getTime()).toInstant(),
						ZoneId.systemDefault())); //5
		member.setNo(rs.getLong(1)); //"NUMBER"
		return member;
	}

}
