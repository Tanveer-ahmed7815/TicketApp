package com.concertapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concertapp.dto.TicketDto;

@Repository
public interface TicketDao extends CrudRepository<TicketDto, Integer> {

	@Query("Select c.ticketNo from TicketDto c where c.ticketNo in (:tickNolist)")
	List<Integer> validateTicketNos(@Param("tickNolist") List<Integer> ticketNoList);

}
