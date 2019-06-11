package com.ing.modelbank.servicetest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.controller.FundTransferController;
import com.ing.modelbank.pojo.FundTRansferRequest;
import com.ing.modelbank.pojo.FundTRansferResponse;
import com.ing.modelbank.service.FundTransferService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FundTransferControllerTest {

	 private MockMvc mockMvc;
	 @MockBean
	 FundTransferService service;
	 @InjectMocks
	 FundTransferController controller;
	 
	 @Autowired 
		private WebApplicationContext wac;
		 
		@Before
		public void setup() { 
			this.mockMvc =  MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
		@Test
		public void whileTransferingFunds() throws Exception {
			
			FundTRansferRequest request = new FundTRansferRequest();
			request.setAmount(1000.0);
			request.setBeneficiaryId("ING001");
			request.setCustomerId("ING002");
			request.setRemarks("Loan");
		
			FundTRansferResponse response = new FundTRansferResponse();
			response.setReferenceId(12345L);
			response.setStatus("success");
			Mockito.when(service.saveTansaction(request)).thenReturn(response);
			
			mockMvc.perform(put("/api/funds").accept(MediaType.
					 APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON) .content(asJsonString(request)))
					.andExpect(status().isCreated()).andDo(print()); 
		}
		
		
		
		public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
