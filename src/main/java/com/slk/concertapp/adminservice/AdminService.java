package com.slk.concertapp.adminservice;

import java.util.List;

import com.slk.concertapp.adminreqdto.AdminReqDto;
import com.slk.concertapp.response.ResponseBean;

public interface AdminService {

	ResponseBean createConcert(AdminReqDto adminReqDto);

	List<AdminReqDto> fetchConcertDetails();



}
