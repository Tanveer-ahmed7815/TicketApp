package com.slk.concertapp.customerdao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slk.concertapp.customerdto.CustomerDto;
import com.slk.concertapp.customerdto.TicketDto;

@Repository
public interface CustomerDao extends CrudRepository<CustomerDto, Integer> {

	TicketDto findByTicketNo(int ticketNo);

	
}
