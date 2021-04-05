package com.concertapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concertapp.dto.CustomerDto;
import com.concertapp.dto.TicketDto;

@Repository
public interface CustomerDao extends CrudRepository<CustomerDto, Integer> {

	
	
	
}
