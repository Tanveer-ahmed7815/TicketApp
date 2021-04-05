package com.slk.concertapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.concertapp.adminreqdto.AdminReqDto;
import com.slk.concertapp.adminservice.AdminService;
import com.slk.concertapp.response.ResponseBean;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping
	public ResponseEntity<ResponseBean> createConcert(@RequestBody AdminReqDto adminReqDto) {

		ResponseBean res = adminService.createConcert(adminReqDto);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseBean(null, "concert not created", true));
		} else {
			res.setMessage("concert created succesfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(res);
		}
	}

	@GetMapping
	public List<AdminReqDto> fetchConcertDetails() {

		List<AdminReqDto> cocertDetailList = adminService.fetchConcertDetails();
		return cocertDetailList;
	}
}
