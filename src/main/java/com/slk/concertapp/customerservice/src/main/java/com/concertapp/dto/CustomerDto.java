package com.concertapp.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "concert_name")
	private String concertName;

	@Column(name = "mob_number")
	private String mobNumber;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private List<TicketDto> ticketDto;

	@Column(name = "ticket_type")
	private String ticketType;

	@Column(name = "ticket_price")
	private BigDecimal ticketPrice;
}
