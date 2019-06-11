package com.ing.modelbank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.controller.CustomerDetailsController;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;
import com.ing.modelbank.service.CustomerDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerDetailsController.class, secure = false)
public class CustomerDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerDetailsService service;

	@Test
	public void getCustomerDetails() throws Exception {
		CustomerDetaillsResponse response = new CustomerDetaillsResponse();
		response.setId(1l);
		Mockito.when(service.getCustomerDetails(Matchers.anyObject())).thenReturn(response);
		mockMvc.perform(get("/api/customers/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(response)))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
