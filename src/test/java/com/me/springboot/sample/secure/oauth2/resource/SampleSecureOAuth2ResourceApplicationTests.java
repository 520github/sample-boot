package com.me.springboot.sample.secure.oauth2.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SampleSecureOAuth2ResourceApplication.class)
@WebIntegrationTest(randomPort=true)
public class SampleSecureOAuth2ResourceApplicationTests {
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	FilterChainProxy filterChain;
	
	private MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.context).addFilters(this.filterChain).build();
		SecurityContextHolder.clearContext();
	}
	
	@Test
	public void homePageAvailable() throws Exception {
		this.mvc.perform(get("/").accept(MediaTypes.HAL_JSON)).andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void flightsSecuredByDefault() throws Exception {
		this.mvc.perform(get("/flights").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
		this.mvc.perform(get("/flights/1").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isUnauthorized()).andDo(print());
	}

	@Test
	public void profileAvailable() throws Exception {
		this.mvc.perform(get("/profile").accept(MediaTypes.HAL_JSON))
				.andExpect(status().isOk()).andDo(print());
	}
	
}
