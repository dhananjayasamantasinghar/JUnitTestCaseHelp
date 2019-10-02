package com.irctc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.irctc.model.Passanger;
import com.irctc.model.Ticket;
import com.irctc.repo.IrctcRepo;

@Service
public class IrctcService {

	//@Value("${WelcomeMessage}")
	//private String message;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IrctcRepo irctcRepo;
	
	public String getMessage(){
		return env.getProperty("WelcomeMessage");	
	}
	public Ticket bookTicket(Passanger passanger){
		Ticket ticket=new Ticket();
		//business logic
		ticket.setSource(passanger.getSource());
		ticket.setDestination(passanger.getDestination());
		ticket.setJourneyDate(passanger.getJourneyDate());
		ticket.setCoachNo("B3");
		ticket.setSeatNo(43);
		ticket.setPnr(String.valueOf(new Random().nextInt()));
		ticket.setStatus("CNF");
		return irctcRepo.save(ticket);
		
	}
	
	public Ticket getTicket(String pnr){
		return irctcRepo.findByPnr(pnr);
	}
}
