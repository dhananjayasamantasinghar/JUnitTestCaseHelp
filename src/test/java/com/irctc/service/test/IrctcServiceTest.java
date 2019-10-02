package com.irctc.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.irctc.model.Passanger;
import com.irctc.model.Ticket;
import com.irctc.repo.IrctcRepo;
import com.irctc.service.IrctcService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IrctcServiceTest {

	@Autowired
	private IrctcService irctcServie;

	@MockBean
	private IrctcRepo irctcRepo;

	private Ticket ticket;

	@Before
	public void setUp() {
		ticket = new Ticket();
		ticket.setSource("marathahalli");
		ticket.setDestination("silkboard");
		ticket.setJourneyDate("25/06/2019");
		ticket.setCoachNo("B3");
		ticket.setSeatNo(43);
		ticket.setPnr("256423");
		ticket.setStatus("CNF");
		Mockito.when(irctcRepo.save(Mockito.any())).thenReturn(ticket);
		Mockito.when(irctcRepo.findByPnr("256423")).thenReturn(ticket);
	}

	@Test
	public void getMessageTest() {
		Assert.assertEquals("welcome to irctc", irctcServie.getMessage());
	}

	@Test
	public void bookTicketTest() {
		// Input
		Passanger passanger = new Passanger();
		passanger.setName("lija");
		passanger.setAge(26);
		passanger.setAdharNo("7879557825");
		passanger.setSource("marathahalli");
		passanger.setDestination("silkboard");
		passanger.setMobileNo("457687698379");
		passanger.setJourneyDate("25/06/2019");

		Ticket bookTicket = irctcServie.bookTicket(passanger);

		Assert.assertEquals("silkboard", bookTicket.getDestination());
		Assert.assertEquals("B3", bookTicket.getCoachNo());
		Assert.assertEquals("256423", bookTicket.getPnr());
	}

	@Test
	public void getTicketTest() {

		Ticket ticketRes = irctcServie.getTicket("256423");

		Assert.assertEquals("silkboard", ticketRes.getDestination());
		Assert.assertEquals("B3", ticketRes.getCoachNo());
		Assert.assertEquals("256423", ticketRes.getPnr());
	}
}
