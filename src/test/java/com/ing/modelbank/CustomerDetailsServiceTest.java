/**
 * 
 */
package com.ing.modelbank;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;
import com.ing.modelbank.repository.CustomerDetailsRepository;
import com.ing.modelbank.service.CustomerDetailsServiceImpl;

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

	@InjectMocks
	CustomerDetailsServiceImpl service;
	
	@Test
	public void getCustomerDetails() {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setId(1l);
		Mockito.when(repo.findByCustomerId(Matchers.anyObject())).thenReturn(customerDetails);
		CustomerDetaillsResponse response = service.getCustomerDetails("2l");
		assertNotNull(response.getId());
	}

}
