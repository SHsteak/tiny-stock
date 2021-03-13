package com.ts.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ts.api.hello.HelloCtrl;

@WebMvcTest(HelloApiTest.class)
public class HelloApiTest {
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(HelloCtrl.class)
				.alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
	}

	@Test
	public void hello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/hello")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
}
