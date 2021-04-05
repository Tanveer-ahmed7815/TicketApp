package com.concertapp.adminservice;

import java.util.List;

import com.concertapp.requestdto.AdminReqDto;
import com.concertapp.responseentity.ResponseBean;

public interface AdminService {

 public ResponseBean createConcert(AdminReqDto adminReqDto);

 public List<AdminReqDto> fetchAllConcert();


}
