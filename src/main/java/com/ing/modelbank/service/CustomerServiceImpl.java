package com.ing.modelbank.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.pojo.LoginRequest;
import com.ing.modelbank.pojo.LoginResponse;
import com.ing.modelbank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

		
		@Autowired
		CustomerRepository customerRepository;

		@Transactional
		public LoginResponse findByCustomerIdAndPassword(LoginRequest loginRequest)  throws DataNotFoundException{
			 
				LoginResponse response = new LoginResponse();
				Customer customer  = customerRepository.findByCustomerIdAndPassword(loginRequest.getCustomerId(),loginRequest.getPassword());
				
				if(customer ==null || customer.getCustomerId() ==null) {
					throw new DataNotFoundException("Invalid Credentials"); 
				}
				response.setStatus("LoginSuccessfully");
				response.setCustomerId(loginRequest.getCustomerId());
				response.setId(customer.getId());
				return response;
			
	}

}
