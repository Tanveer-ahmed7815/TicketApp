package com.concertapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concertapp.adminservice.AdminService;
import com.concertapp.requestdto.AdminReqDto;
import com.concertapp.responseentity.ResponseBean;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping
	public ResponseEntity<ResponseBean> createConcert(@RequestBody AdminReqDto adminReqDto) {

		ResponseBean res = adminService.createConcert(adminReqDto);
		if (res.getObj() == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseBean(null, "invalid data", true));
		} else {
			res.setMessage("concert created successfully");
			return ResponseEntity.ok(res);
		}
	}

	@GetMapping
	public List<AdminReqDto> fetchAllConcert() {

		return adminService.fetchAllConcert();

	}
}