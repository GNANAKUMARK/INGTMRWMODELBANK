package com.ing.modelbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.pojo.LoginRequest;
import com.ing.modelbank.pojo.LoginResponse;
import com.ing.modelbank.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/users")
	public ResponseEntity<LoginResponse> customerLogin(@RequestBody LoginRequest loginRequest){
		
		Customer customer = new Customer();
		LoginResponse response = customerService.findByCustomerIdAndPassword(loginRequest);
		if(response.getStatus().equalsIgnoreCase("LoginSuccessfully")){
			response.setStatus("Successfully Logged in.....");
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
		}
		return new ResponseEntity<LoginResponse>(response,HttpStatus.NOT_FOUND);
	}
}
