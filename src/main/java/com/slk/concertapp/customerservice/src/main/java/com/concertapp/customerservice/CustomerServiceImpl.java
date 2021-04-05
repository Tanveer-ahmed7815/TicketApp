package com.concertapp.customerservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.concertapp.dao.AdminDao;
import com.concertapp.dao.CustomerDao;
import com.concertapp.dao.TicketDao;
import com.concertapp.dto.AdminDto;
import com.concertapp.dto.CustomerDto;
import com.concertapp.dto.TicketDto;
import com.concertapp.exception.ResourceNotFoundException;
import com.concertapp.exception.TicketBlockedException;
import com.concertapp.requestdto.CustomerReqDto;
import com.concertapp.responseentity.ResponseBean;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	AdminDao adminDao;

	@Autowired
	TicketDao ticketDao;

	@Override
	public ResponseBean buyTicket(CustomerReqDto customerReqDto) {

		// AdminDto adminDto = adminDao.findByConcertNameAndTicketType();

//		AdminDto adminDto = adminDao.findConcertDetails(customerReqDto.getConcertName(),
//				customerReqDto.getTicketType());

//		setTicketDetail(customerReqDto.getTicketDto(), customerDto);

		AdminDto adminDto = adminDao.findConcertDetails(customerReqDto.getConcertName(),
				customerReqDto.getTicketType());

		if (adminDto == null) {
			throw new ResourceNotFoundException("Resource Not Found");
		} else {

			List<TicketDto> ticketObjList = customerReqDto.getTicketDto();
			List<Integer> ticketNoList = new ArrayList<>();
			for (TicketDto ticketNo : ticketObjList) {
				ticketNoList.add(ticketNo.getTicketNo());
			}
			List<Integer> ticketList = ticketDao.validateTicketNos(ticketNoList);

			if (!CollectionUtils.isEmpty(ticketList)) {
				throw new TicketBlockedException("ticket already booked", ticketList);
			}
			{
				BigDecimal price = adminDto.getTicketPrice();
				List<TicketDto> list = new ArrayList<>();
				CustomerDto customerDto = new CustomerDto();
				for (TicketDto ticketDto : ticketObjList) {

					if (ticketDto.getTicketNo() <= adminDto.getTicketNoTo()
							&& ticketDto.getTicketNo() >= adminDto.getTicketNoFrom()
							&& customerReqDto.getTicketPrice().equals(price)) {
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
	}



}
