package com.concertapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concertapp.dto.CustomerDto;

@Repository
public interface CustomerDao extends CrudRepository<CustomerDto, Integer> {

}
