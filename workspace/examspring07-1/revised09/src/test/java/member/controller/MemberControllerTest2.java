package member.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import member.common.AlreadyMemberException;
import member.controller.validator.RegisterCommand;
import member.repository.Member;
import member.service.MemberService;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest2 {
	
	@Mock
	private MemberService memberService;

	@InjectMocks
	private MemberController controller;
	
	private MockMvc mockMvc;
	
	@Test
	void testStep2() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/register/step2")
				.param("agree", "true"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("register/step2"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("command"));
	}
	
	@Test
	void testStep2NoAgree() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/register/step2")
				.param("agree", "false"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("register/step1"));
	}	
	
	@Test
	void step3PostTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/register/step3")
				.param("memberid", "test@test.com")
				.param("memberpw", "1234")
				.param("memberpw2", "1234")
				.param("nick", "nick")
				.param("agree", "true")
				)
				.andExpect(MockMvcResultMatchers.view().name("register/step3"));
	}
	
	@Test
	void testStep3() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/register/step3")
				.param("memberid", "testId@test.com")
				.param("memberpw", "testPw")
				.param("memberpw2", "testPw")
				.param("nick", "testNick"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("register/step3"));
	}
}
