package com.acme.claim.process.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acme.claim.process.api.repository.model.CustomerData;


@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {
	
	public CustomerData findByCustomerId(@Param("id") Long id) ;

}
