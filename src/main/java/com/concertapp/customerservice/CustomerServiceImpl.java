package com.concertapp.customerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertapp.dao.AdminDao;
import com.concertapp.dao.CustomerDao;
import com.concertapp.dto.AdminDto;
import com.concertapp.dto.CustomerDto;
import com.concertapp.dto.TicketDto;
import com.concertapp.exception.ResourceNotFoundException;
import com.concertapp.requestdto.CustomerReqDto;
import com.concertapp.responseentity.ResponseBean;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	AdminDao adminDao;

	@Override
	public ResponseBean buyTicket(CustomerReqDto customerReqDto) {

		// AdminDto adminDto = adminDao.findByConcertNameAndTicketType();

//		AdminDto adminDto = adminDao.findConcertDetails(customerReqDto.getConcertName(),
//				customerReqDto.getTicketType());
		CustomerDto customerDto = new CustomerDto();
//		setTicketDetail(customerReqDto.getTicketDto(), customerDto);

		AdminDto adminDto = adminDao.findConcertDetails(customerReqDto.getConcertName(),
				customerReqDto.getTicketType());
		if (adminDto == null) {
			throw new ResourceNotFoundException("Resource Not Found");
		} else {
			List<TicketDto> tickNolist = customerReqDto.getTicketDto();
			List<TicketDto> list = new ArrayList<>();
			for (TicketDto ticketDto : tickNolist) {
				if (ticketDto.getTicketNo() <= adminDto.getTicketNoTo()
						|| ticketDto.getTicketNo() >= adminDto.getTicketNoFrom()) {
					list.add(ticketDto);
				}
			}

			BeanUtils.copyProperties(customerReqDto, customerDto);
			customerDao.save(customerDto);
			ResponseBean res = new ResponseBean();
			res.setObj(customerDto);

			return res;
		}
	}

//	private void setTicketDetail(List<TicketDto> ticketList, CustomerDto customerDto) {
//
//		List<TicketDto> list = new ArrayList<>();
//		for (TicketDto ticket : ticketList) {
//
//			TicketDto ticketDto = new TicketDto();
//			BeanUtils.copyProperties(ticket, ticketDto);
//			list.add(ticketDto);
//		}
//		customerDto.setTicketDto(list);
//
//	}

}
