package com.acme.claim.process.api.service;

import com.acme.claim.process.api.model.Address;

public interface AddressService {
	
	public boolean validateAddress(Address address) throws Exception;
	
	public String getAddressValidationURL();

	public void setAddressValidationURL(String addressValidationURL);
}
