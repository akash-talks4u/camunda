package com.acme.claim.process.api.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.claim.process.api.model.Customer;
import com.acme.claim.process.api.service.CustomerService;

@Service("getCustomerDetailsDelegate")
public class GetCustomerDetailsDelegate implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(GetCustomerDetailsDelegate.class.getName());

	@Autowired
	private CustomerService customerService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		try {
			LOGGER.info("GetCustomerDetailsDelegate Invoked");

			// TODO Auto-generated method stub
			Long insuranceId = (Long) execution.getVariable("InsuranceId");
			Customer customer = null;
			customer = customerService.findCustomerById(insuranceId);
			execution.setVariable("EmailAddress", customer.getEmail());
			execution.setVariable("customer", customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BpmnError("Claim-Error-002", "Invalid Insurance Id");
		}

	}

}
