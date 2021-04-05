package com.slk.concertapp.admindao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slk.concertapp.admindto.AdminDto;

@Repository
public interface AdminDao extends CrudRepository<AdminDto, Integer> {

	

	

}
