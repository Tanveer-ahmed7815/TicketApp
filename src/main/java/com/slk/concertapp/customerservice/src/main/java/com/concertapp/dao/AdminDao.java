package com.concertapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.concertapp.dto.AdminDto;

@Repository
public interface AdminDao extends CrudRepository<AdminDto, Integer> {

//	AdminDto findByConcertName();

	@Query("select c from AdminDto c where c.concertName = :concertName AND c.ticketType = :ticketType")
	AdminDto findConcertDetails(@Param("concertName") String concertName, @Param("ticketType") String ticketType);

//	@Query("Select c from AdminDto where  c.concertName = :concertName AND c.ticketType = :ticketType")
//	AdminDto findConcertDetails(@Param("concertName") String concertName, @Param("ticketType") String ticketType);

	// AdminDto findByConcertNameAndTicketType();

}
