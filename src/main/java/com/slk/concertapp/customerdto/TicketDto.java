package com.slk.concertapp.customerdto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "ticket_no")
	private int ticketNo;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerDto customerDto;
}
