/**
 * 
 */
package com.ing.modelbank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;
import com.ing.modelbank.pojo.LoginRequest;
import com.ing.modelbank.pojo.LoginResponse;
import com.ing.modelbank.repository.CustomerDetailsRepository;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.service.CustomerDetailsServiceImpl;
import com.ing.modelbank.service.CustomerServiceImpl;

/**
 * Test Case for Customer Details Service
 * @author ING Dev Team
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDetailsServiceTest {
	@Mock
	CustomerDetailsRepository repo;
	
	@Mock
	CustomerRepository custRepo;

	@InjectMocks
	CustomerDetailsServiceImpl service;
	
	@InjectMocks
	CustomerServiceImpl custServ;
	
	@Test
	public void getCustomerDetails() {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setId(1l);
		Mockito.when(repo.findByCustomerId(Matchers.anyObject())).thenReturn(customerDetails);
		CustomerDetaillsResponse response = service.getCustomerDetails("2");
		assertNotNull(response.getId());
	}
	
	
	@Test(expected = DataNotFoundException.class)
	public void getCustomerDetailsException() {
		CustomerDetails customerDetails = new CustomerDetails();
		Mockito.when(repo.findByCustomerId(Matchers.anyObject())).thenReturn(customerDetails);
		CustomerDetaillsResponse response = service.getCustomerDetails("2");
		assertNotNull(response.getId());
	}
	
	@Test
	public void getLogin() {
		Customer cust = new Customer();
		cust.setCustomerId("ING001");
		cust.setPassword("12345678");
		LoginRequest request = new LoginRequest();
		request.setCustomerId("ING001");
		request.setPassword("12345678");
		Mockito.when(custRepo.findByCustomerIdAndPassword(Matchers.anyObject(),Matchers.anyObject())).thenReturn(cust);		
		LoginResponse response = custServ.findByCustomerIdAndPassword(request);
		assertEquals(request.getCustomerId(),response.getCustomerId());

	}
	
}
