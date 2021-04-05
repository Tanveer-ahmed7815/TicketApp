package com.concertapp.responseentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
	
	private Object obj;
	
	private String message;
	
	private boolean error;
}
