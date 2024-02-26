package member.controller.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class RegisterCommandValidatorTest {

	private RegisterCommandValidator validator;
	private RegisterCommand cmd;
	private Errors errors;
	
	@BeforeEach
	void setUp() {
		validator = new RegisterCommandValidator();
		cmd = new RegisterCommand();
		errors = new BeanPropertyBindingResult(cmd, "cmd");
	}
	
	@Test
	void testValidate() {
		//정상적인 동작
//		cmd.setMemberid("test@test.com");
//		cmd.setNick("testNick");
//		cmd.setMemberpw("testPw");
//		cmd.setMemberpw2("testPw");
//		
//		validator.validate(cmd, errors);
//		assertFalse(errors.hasErrors());
		
		//값이 비어있을 때(에러가 존재하는지 확인)
		cmd.setMemberid("test");
		cmd.setNick("");
		cmd.setMemberpw("");
		cmd.setMemberpw2("test");
		
		validator.validate(cmd, errors);
		assertTrue(errors.hasErrors());
		
//		assertEquals(4, errors.getFieldErrorCount("memberid"));
//		assertEquals(1, errors.getFieldErrorCount("nick"));
//		assertEquals(2, errors.getFieldErrorCount("memberpw"));
//		assertEquals(1, errors.getFieldErrorCount("memberpw2"));
		
		System.out.println(errors.getFieldError("memberpw").getCode());
		assertEquals("required", errors.getFieldError("memberpw").getCode());
	}

}
