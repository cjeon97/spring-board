package member.repository.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import member.repository.Member;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:root-context.xml", "classpath:servlet-context.xml"})
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	@DisplayName("멤버 조회 테스트")
	public void selectTest() {
		Member member = mapper.selectByNo(18L);
		Assertions.assertNotNull(member);
	}
}
