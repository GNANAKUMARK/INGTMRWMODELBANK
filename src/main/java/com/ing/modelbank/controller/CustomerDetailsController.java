/**
 * 
 */
package com.ing.modelbank.controller;

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

import com.ing.modelbank.pojo.CustomerDetaillsResponse;
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
	ResponseEntity<CustomerDetaillsResponse> getCustomerDetails(@PathVariable("customerId") Long customerId) {
		LOGGER.info("Inside getCustomerDetails method CustomerDetailsController customerId:" + customerId);
		CustomerDetaillsResponse customerDetaillsResponse = customerDetailsService.getCustomerDetails(customerId);
		return new ResponseEntity<>(customerDetaillsResponse, HttpStatus.OK);
	}

}
