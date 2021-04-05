package com.slk.concertapp.adminservice;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.concertapp.admindao.AdminDao;
import com.slk.concertapp.admindto.AdminDto;
import com.slk.concertapp.adminreqdto.AdminReqDto;
import com.slk.concertapp.exception.ResourceNotFoundException;
import com.slk.concertapp.response.ResponseBean;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public ResponseBean createConcert(AdminReqDto adminReqDto) {

		AdminDto adminDto = new AdminDto();
		BeanUtils.copyProperties(adminReqDto, adminDto);
		adminDao.save(adminDto);
		ResponseBean res = new ResponseBean();
		res.setObj(adminDto);
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminReqDto> fetchConcertDetails() {

		@SuppressWarnings("rawtypes")
		List<AdminReqDto> concertDetails = (List) adminDao.findAll();
		if (concertDetails.isEmpty()) {
			throw new ResourceNotFoundException("no data available");
		}

		return concertDetails;
	}

}
