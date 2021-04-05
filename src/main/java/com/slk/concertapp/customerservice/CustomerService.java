package com.slk.concertapp.customerservice;

import com.slk.concertapp.contomerreqdto.CustomerReqDto;
import com.slk.concertapp.response.ResponseBean;

public interface CustomerService {

	ResponseBean buyTicket(CustomerReqDto customerReqDto);

}
