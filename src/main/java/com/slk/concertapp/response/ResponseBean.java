package com.slk.concertapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {
	
	private Object obj;
	private String message;
	private boolean error;
}
