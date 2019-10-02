package com.irctc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.model.Ticket;

public interface IrctcRepo extends JpaRepository<Ticket, Integer>{

	Ticket findByPnr(String pnr);
}
