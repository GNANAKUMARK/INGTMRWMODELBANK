/**
 * 
 */
package com.ing.modelbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;
import com.ing.modelbank.pojo.CustomerResponse;
import com.ing.modelbank.service.CustomerDetailsService;

/**
 * Controller for Account details
 * 
 * @author ING Dev Team
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class CustomerDetailsController {
	private static final Logger LOGGER = LogManager.getLogger(CustomerDetailsController.class);

	@Autowired
	CustomerDetailsService customerDetailsService;

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<CustomerDetaillsResponse> getCustomerDetails(@PathVariable("customerId") String customerId) {
		LOGGER.info("Inside getCustomerDetails method CustomerDetailsController customerId:" + customerId);
		CustomerDetaillsResponse customerDetaillsResponse = customerDetailsService.getCustomerDetails(customerId);
		return new ResponseEntity<>(customerDetaillsResponse, HttpStatus.OK);
	}
	@GetMapping("/beneficiaries/{customerId}")
	public ResponseEntity<List<CustomerResponse>> getBeneficiariesDetails(@PathVariable("customerId") String customerId){
		
		 	List<CustomerDetails> list = customerDetailsService.findByAll();
			
			if(list.isEmpty()) {
				throw new DataNotFoundException("You have not yet sent any request");
			}
			
			List<CustomerResponse> list1 = new ArrayList<>();
			
			for (CustomerDetails CustomerDetails : list) {
				CustomerResponse customerResponse = new CustomerResponse();
				if(CustomerDetails.getCustomerId().equalsIgnoreCase(customerId)) {
					
					continue;
					
				}
				customerResponse.setCustomerName(CustomerDetails.getCustomerName());
				customerResponse.setCustomerId(CustomerDetails.getCustomerId());
				list1.add(customerResponse);
			}
			
			return new ResponseEntity<>(list1, HttpStatus.OK);
	}
}
