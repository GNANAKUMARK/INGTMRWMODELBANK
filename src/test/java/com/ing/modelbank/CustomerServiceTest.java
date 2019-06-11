package com.ing.modelbank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.exception.DataNotFoundException;
import com.ing.modelbank.pojo.LoginRequest;
import com.ing.modelbank.pojo.LoginResponse;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CustomerServiceTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CustomerRepository repo;
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl;
	

	 @Autowired 
		private WebApplicationContext wac;
	
	@Before
	public void setup() { 
		this.mockMvc =  MockMvcBuilders.webAppContextSetup(wac).build();
	
}
	
	@Test(expected = DataNotFoundException.class)
	public void whileLogin() throws Exception {
		Customer customer = new Customer();

		LoginResponse response = new LoginResponse();
		LoginRequest request = new LoginRequest();
		request.setCustomerId("ING001");
		request.setPassword("12345678");
		
		Mockito.when(customerServiceImpl.findByCustomerIdAndPassword(request)).thenReturn(response);
		assertThat(request.getCustomerId()).isEqualTo(response.getCustomerId());
		
		
		  mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());	
	}
	
}
