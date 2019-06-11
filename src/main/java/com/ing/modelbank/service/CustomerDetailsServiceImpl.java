/**
 * 
 */
package com.ing.modelbank.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;
import com.ing.modelbank.repository.CustomerDetailsRepository;

/**
 * Service implementation for Customer Details Service
 * 
 * @author ING Dev team
 *
 */
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
	private static final Logger LOGGER = LogManager.getLogger(CustomerDetailsServiceImpl.class);

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;

	@Override
	public CustomerDetaillsResponse getCustomerDetails(String customerId) {
		LOGGER.debug("inside CustomerDetailsServiceImpl ::getCustomerDetails() customerId: " + customerId);
		CustomerDetaillsResponse customerDetaillsResponse = new CustomerDetaillsResponse();
		CustomerDetails customerDetails = customerDetailsRepository.findByCustomerId(customerId);
		if (customerDetails == null || customerDetails.getId()==null ) {
			throw new DataNotFoundException("No Customer details are found for customerId:" + customerId);
		}

		customerDetaillsResponse.setAccountType(customerDetails.getAccountType());
		customerDetaillsResponse.setBalance(customerDetails.getBalance());
		customerDetaillsResponse.setCreationDate(customerDetails.getCreationDate());
		customerDetaillsResponse.setCustomerId(customerDetails.getCustomerId());
		customerDetaillsResponse.setCustomerName(customerDetails.getCustomerName());
		customerDetaillsResponse.setId(customerDetails.getId());
		return customerDetaillsResponse;
	}

	@Override
	public List<CustomerDetails> getBeneficiariesDetails(String customerId) {
		
		List<CustomerDetails> customerDetails = customerDetailsRepository.findAll();
		
		
		return (List<CustomerDetails>) customerDetails;
		
	}

	@Override
	public List<CustomerDetails> findByAll() {
		
		return customerDetailsRepository.findAll();
	}

}
