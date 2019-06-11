package com.ing.modelbank.servicetest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.entity.CustomerTransactions;
import com.ing.modelbank.pojo.FundTRansferRequest;
import com.ing.modelbank.pojo.FundTRansferResponse;
import com.ing.modelbank.repository.CustomerDetailsRepository;
import com.ing.modelbank.repository.FundTransferRepository;
import com.ing.modelbank.service.FundTransferServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FundTransferServiceTest {
	@Mock
	CustomerDetailsRepository repo;
	@Mock
	FundTransferRepository repository;
	@InjectMocks
	FundTransferServiceImpl service;
	
	@Test
	public void whileMakingFundTransfer() {
		
		FundTRansferRequest request = new FundTRansferRequest();
		request.setAmount(1000.0);
		request.setBeneficiaryId("ING001");
		request.setCustomerId("ING002");
		request.setRemarks("Loan");
		CustomerTransactions transaction = new CustomerTransactions();
		transaction.setAmount(request.getAmount());
		transaction.setComments(request.getRemarks());
		
		
		FundTRansferResponse response = new FundTRansferResponse();
		response.setReferenceId(12454L);
		response.setStatus("success");
		
		CustomerDetails customer = new CustomerDetails();
		customer.setId(1L);
		customer.setCustomerId("ING001");
		customer.setCustomerName("karthik");
		customer.setBalance(10000.0);
		Mockito.when(repo.findByCustomerId("ING001")).thenReturn(customer);
		CustomerDetails customer1=repo.findByCustomerId("ING001");
		assertThat(customer1).isEqualTo(customer);
		
		
		Mockito.when(repository.save(transaction)).thenReturn(transaction);
		CustomerTransactions transaction1 = repository.save(transaction);
		assertThat(transaction).isEqualTo(transaction1);
		
	}

}
