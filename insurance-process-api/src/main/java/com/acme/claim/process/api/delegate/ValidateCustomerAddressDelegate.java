package com.acme.claim.process.api.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.claim.process.api.model.Address;
import com.acme.claim.process.api.service.AddressService;

@Service("validateCustomerAddressDelegate")
public class ValidateCustomerAddressDelegate implements JavaDelegate {
	
	  private final Logger LOGGER = Logger.getLogger(ValidateCustomerAddressDelegate.class.getName());

	
	@Autowired
	private AddressService addressService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		 /* <camunda:formField id="ClaimDate" label="Enter the Claim Date" type="date" />
       <camunda:formField id="ClaimAddressFirstLine" label="Enter the Street Address" type="string" />
         <camunda:formField id="ClaimLastName" label="Enter the Claim Last Name" type="string" />
         <camunda:formField id="ClaimAmount" label="Enter the Claim Amount" type="long" />
         <camunda:formField id="ClaimAddressCity" label="Enter the Claim City" type="string" />
         <camunda:formField id="ClaimAddressState" label="Enter the Claim Address State" type="string" />
         <camunda:formField id="ClaimAddressZipCode" label="Enter the ZipCode" type="string" />
         <camunda:formField id="InsuranceId" label="Enter the Insurance Id" type="long" />*/
		LOGGER.info("ValidateCustomerAddressDelegate invoked");

		try {
			String street=(String)execution.getVariable("ClaimAddressFirstLine");
			String city=(String)execution.getVariable("ClaimAddressCity");
			String state=(String)execution.getVariable("ClaimAddressState");
			String zip=(String)execution.getVariable("ClaimAddressZipCode");
			
			Address address=new Address();
			address.setStreetAddress(street);
			address.setCity(city);
			address.setState(state);
			address.setZipCode(zip);
			boolean addressDecsion=addressService.validateAddress(address);
			LOGGER.info("addressDecsion"+addressDecsion);
			execution.setVariable("Address_Validaction_Result",addressDecsion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BpmnError("Claim-Error-001","Invalid Address");
		}

	}

}
