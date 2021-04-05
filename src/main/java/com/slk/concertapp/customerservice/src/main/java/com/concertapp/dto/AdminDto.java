package com.concertapp.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="concert_table")
@Data
@NoArgsConstructor
public class AdminDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="concert_id")
    private int concertId;
	
	@Column(name="concert_name")
	private String concertName;
	
	@Column(name="ticket_no_from")
	private int ticketNoFrom;
	
	@Column(name="ticket_no_to")
	private int ticketNoTo;
	
	@Column(name="ticket_type")
	private String ticketType;
	
	@Column(name="ticket_price")
	private BigDecimal ticketPrice;
}
