package com.concertapp.adminservice;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concertapp.dao.AdminDao;
import com.concertapp.dto.AdminDto;
import com.concertapp.exception.ResourceNotFoundException;
import com.concertapp.requestdto.AdminReqDto;
import com.concertapp.responseentity.ResponseBean;

@Component
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

	
	@Override
	public List<AdminReqDto> fetchAllConcert() {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<AdminReqDto> list = (List) adminDao.findAll();
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("No data available");
		}
		return list;

	}

}
