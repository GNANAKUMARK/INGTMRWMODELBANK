/**
 * 
 */
package com.ing.modelbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.entity.CustomerTransactions;
import com.ing.modelbank.repository.FundTransferRepository;

/**
 * Service implementation for Customer Details Service
 * @author ING Dev team
 *
 */
@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {
	
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	public CustomerTransactions getTransactionDetailsForId(Long id) {
		return fundTransferRepository.findRequestById(id);
	}

	
	public List<CustomerTransactions> getTransactionDetailsforId(Long id) {
	
		return fundTransferRepository.findTransactionById(id);
	}

}
