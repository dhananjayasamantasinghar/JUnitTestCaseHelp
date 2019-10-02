package com.irctc.controllet.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.irctc.controller.IrctcController;
import com.irctc.service.IrctcService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IrctcControllerTest {
	
	@Autowired
	private IrctcController irctcController;
	
	@MockBean	
	private IrctcService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup( irctcController ).build();
	}
	
	@Test
	public void getWelcomeMessageTest() throws Exception{
		Mockito.when(service.getMessage()).thenReturn("dhananjaya");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/irctc/home"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("dhananjaya"));
	}
	

}
