package member.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:root-context.xml", "classpath:servlet-context.xml"})
@WebAppConfiguration
public class MemberControllerTest {
	
	@Autowired
	private WebApplicationContext webCtx;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webCtx).build();
	}

	@Test
	void step1Test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/register/step1"));
	}
	
	@Test
	void step2GetTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/register/step2")
				.param("agree", "true"));
	}
	
	@Test
	void step2PostTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post("/register/step2")
				.param("agree", "true")
				)
				.andExpect(MockMvcResultMatchers.view().name("register/step2"));
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
	
	
}
