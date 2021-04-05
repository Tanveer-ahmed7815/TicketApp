package com.concertapp.exception;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TicketBlockedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private List<Integer> list;

	public TicketBlockedException(String message, List<Integer> list) {
		this.message = message;
		this.list = list;
	}

}
