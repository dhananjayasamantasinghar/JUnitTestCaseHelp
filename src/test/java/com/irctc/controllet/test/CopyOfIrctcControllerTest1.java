package com.irctc.controllet.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.irctc.controller.IrctcController;
import com.irctc.service.IrctcService;


@RunWith(SpringRunner.class)
@WebMvcTest(value={IrctcController.class})
public class CopyOfIrctcControllerTest1 {
	
	
	@MockBean	
	private IrctcService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getWelcomeMessageTest() throws Exception{
		Mockito.when(service.getMessage()).thenReturn("dhananjaya");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/irctc/home"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("dhananjaya"));
	}
	

}
