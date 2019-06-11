package com.ing.modelbank.controller;

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

import com.ing.modelbank.entity.CustomerTransactions;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.service.TransactionDetailsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class TransactionDetailsController {
	private static final Logger LOGGER = LogManager.getLogger(TransactionDetailsController.class);
	@Autowired
	 TransactionDetailsService transactionDetailsService;
	@GetMapping(value = "/transactions/{id}")
	public ResponseEntity<CustomerTransactions> getTransactionDetailsForId(@PathVariable("id") Long id )
			throws Exception {
		
		CustomerTransactions response = transactionDetailsService.getTransactionDetailsForId(id);
		if (response == null || response.getId() <= 0) {
			throw new DataNotFoundException("No Data Found for id" + id);
		}
		return new ResponseEntity<CustomerTransactions>(response,HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "/transaction/{customer_Id}")
	public ResponseEntity<List<CustomerTransactions>> getTransactionDetailsForCustomerId(@PathVariable("customer_Id") String customer_Id )
			throws Exception {
		
		List<CustomerTransactions> response = transactionDetailsService.getTransactionDetailsforId(customer_Id);
		if (response.isEmpty() ) {
			throw new DataNotFoundException("No Data Found for  customer id"+" "+customer_Id );
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	}
