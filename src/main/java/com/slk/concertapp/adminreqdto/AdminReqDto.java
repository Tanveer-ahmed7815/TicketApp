package com.slk.concertapp.adminreqdto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminReqDto {
	
	private int concertId;
	
	private String concertName;
	
	private int ticketNoFrom;
	
	private int ticketNoTo;
	
	private String ticketType;
	
	private BigDecimal ticketPrice;
}
