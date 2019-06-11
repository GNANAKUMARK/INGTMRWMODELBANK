/**
 * 
 */
package com.ing.modelbank.service;

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
		// TODO Auto-generated method stub
		return fundTransferRepository.findRequestById(id);
	}

}
