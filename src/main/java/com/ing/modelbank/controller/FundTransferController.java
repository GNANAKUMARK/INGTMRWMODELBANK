package com.ing.modelbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.pojo.FundTRansferRequest;
import com.ing.modelbank.pojo.FundTRansferResponse;
import com.ing.modelbank.service.FundTransferService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class FundTransferController {
	
	@Autowired
	FundTransferService service;
	
	@PutMapping("/funds")
	public ResponseEntity<FundTRansferResponse> fundTransfer(@RequestBody FundTRansferRequest request){
		
		FundTRansferResponse response = service.saveTansaction(request);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}

}
