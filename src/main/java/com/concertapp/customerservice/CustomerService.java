package com.concertapp.customerservice;

import com.concertapp.requestdto.CustomerReqDto;
import com.concertapp.responseentity.ResponseBean;

public interface CustomerService {

  public ResponseBean buyTicket(CustomerReqDto customerReqDto);

}
