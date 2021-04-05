package com.slk.concertapp.customerservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.concertapp.contomerreqdto.CustomerReqDto;
import com.slk.concertapp.customerdao.CustomerDao;
import com.slk.concertapp.customerdto.CustomerDto;
import com.slk.concertapp.customerdto.TicketDto;
import com.slk.concertapp.exception.InvalidInputException;
import com.slk.concertapp.response.ResponseBean;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public ResponseBean buyTicket(CustomerReqDto customerReqDto) {

		List<TicketDto> ticketsList = customerReqDto.getTicketDto();
		BigDecimal bd = new BigDecimal(ticketsList.size());
		List<TicketDto> list = new ArrayList<>();
		
		for (TicketDto ticketDto : ticketsList) {

			if (((ticketDto.getTicketNo() >= 1 && ticketDto.getTicketNo() <= 40)
					&& (customerReqDto.getTicketPrice().divide(bd)).equals(new BigDecimal("1000.00")))
					&& (customerReqDto.getTicketType().equalsIgnoreCase("basic"))) {

				list.add(ticketDto);
				break;

			} else if (((ticketDto.getTicketNo() >= 41 && ticketDto.getTicketNo() <= 80)
					&& customerReqDto.getTicketPrice().divide(bd).equals(new BigDecimal("2000.00")))
					&& (customerReqDto.getTicketType().equalsIgnoreCase("premium"))) {

				list.add(ticketDto);
				break;

			} else if (((ticketDto.getTicketNo() >= 81 && ticketDto.getTicketNo() <= 100)
					&& customerReqDto.getTicketPrice().divide(bd).equals(new BigDecimal("3000.00")))
					&& (customerReqDto.getTicketType().equalsIgnoreCase("vip"))) {

				list.add(ticketDto);
				break;

			} else {
				throw new InvalidInputException("Please do check the details before submitting");
			}
		}
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customerReqDto, customerDto);
		customerDao.save(customerDto);
		ResponseBean res = new ResponseBean();
		res.setObj(customerDto);
		return res;
	}

}
