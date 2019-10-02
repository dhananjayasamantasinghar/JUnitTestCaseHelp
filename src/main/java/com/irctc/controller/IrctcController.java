package com.irctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.model.Passanger;
import com.irctc.model.Ticket;
import com.irctc.service.IrctcService;

@RestController
@RequestMapping("/irctc")
public class IrctcController {
	
	@Autowired
	private IrctcService service;
	
	@GetMapping("/home")
	public String getWelcomeMessage() {
		return service.getMessage();
	}
	@PostMapping(value="/bookTicket",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket bookTicket(@RequestBody Passanger passanger){
		return service.bookTicket(passanger);
	}
	@GetMapping(value="/getDummyRequest",produces=MediaType.APPLICATION_JSON_VALUE)
	public Passanger getDummyPassanger(){
		return new Passanger();	
	}
	@GetMapping(value="/getPnr",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicket(@RequestParam("pnr") String pnr){
		return service.getTicket(pnr);
	}
}
