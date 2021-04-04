package com.concertapp.requestdto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminReqDto {
	
	private int concertId;
	
	private String concertName;
	
	private int ticketNoFrom;
	
	private int ticketNoTo;
	
	private String ticketType;
	
	private BigDecimal ticketPrice;
}
