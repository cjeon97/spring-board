package member.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HelloControllerTest {

	private MockMvc mockMvc;
	
	@Test
	void testHello() throws Exception{
		HelloController helloController = new HelloController();
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    
	    mockMvc = MockMvcBuilders.standaloneSetup(helloController)
				.setViewResolvers(resolver)
				.build();
		
	    mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("hello"))
			.andExpect(MockMvcResultMatchers.model().attribute("msg", "hello"));
	}
}
