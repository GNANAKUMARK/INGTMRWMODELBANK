/**
 * 
 */
package com.ing.modelbank.servicetest;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.repository.FundTransferRepository;
import com.ing.modelbank.service.TransactionDetailsService;

/**
 * @author user1
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionDetailsServiceTest {
	@Mock
	FundTransferRepository repo;
	@InjectMocks
	TransactionDetailsService service;
	
	
}
