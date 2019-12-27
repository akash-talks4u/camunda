package com.acme.claim.process.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.claim.process.api.model.Customer;
import com.acme.claim.process.api.repository.CustomerDataRepository;
import com.acme.claim.process.api.repository.model.CustomerData;


@Component("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDataRepository customerRepository;
	
	

	@Override
	public Customer findCustomerById(Long id) {
		Customer customer=new Customer();
		if( id != null){
			CustomerData customerData = customerRepository.findByCustomerId(id);
			customer.setFirstName(customerData.getFirstName());
			customer.setLastName(customerData.getLastName());
			customer.setEmail(customerData.getEmail());
			customer.setPhoneNumber(customerData.getPhoneNumber());
		}
		
		return customer;
	}


}
