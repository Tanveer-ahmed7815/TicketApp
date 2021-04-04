package com.concertapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concertapp.customerservice.CustomerService;
import com.concertapp.requestdto.CustomerReqDto;
import com.concertapp.responseentity.ResponseBean;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping
	public ResponseEntity<ResponseBean> buyTicket(@RequestBody CustomerReqDto customerReqDto) {

		ResponseBean res = customerService.buyTicket(customerReqDto);
		if (res.getObj() == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseBean(null, "invalid credentials", true));
		} else {
			res.setMessage("Ticket bought successfully");
			return ResponseEntity.ok(res);
		}
	}
}
