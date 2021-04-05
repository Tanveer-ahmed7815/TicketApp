package com.slk.concertapp.contomerreqdto;

import java.math.BigDecimal;
import java.util.List;

import com.slk.concertapp.customerdto.TicketDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReqDto {

	private int customerId;
	
	private String concertName;
	
	private String mobNumber;

	private List<TicketDto> ticketDto;

	private String ticketType;
	
	private BigDecimal ticketPrice;

}
