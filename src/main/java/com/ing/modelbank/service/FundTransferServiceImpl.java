package com.ing.modelbank.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.entity.CustomerTransactions;
import com.ing.modelbank.pojo.FundTRansferRequest;
import com.ing.modelbank.pojo.FundTRansferResponse;
import com.ing.modelbank.repository.CustomerDetailsRepository;
import com.ing.modelbank.repository.FundTransferRepository;

@Service
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	FundTransferRepository repository;
	
	@Autowired
	CustomerDetailsRepository repo;
	
	public FundTRansferResponse saveTansaction(FundTRansferRequest request) {
		FundTRansferResponse response = new FundTRansferResponse();
		CustomerDetails detail=repo.findByCustomerId(request.getCustomerId()); 
	
		if(detail.getBalance()<request.getAmount()) {
			response.setReferenceId(0L);
			response.setStatus("Insufficient Balance");
			return response;
		}
		else {
		CustomerTransactions transaction= new CustomerTransactions();
		
		transaction.setFromAccount(request.getCustomerId());
		transaction.setToAccount(request.getBeneficiaryId());
		transaction.setAmount(request.getAmount());
		transaction.setComments(request.getRemarks());
		Random random = new Random();
		long referenceId = 10000000 + random.nextInt(900000);
		transaction.setReferenceId(referenceId);
		CustomerTransactions transaction1=repository.save(transaction);
		detail.setBalance(detail.getBalance()-transaction.getAmount());
		repo.save(detail);
		response.setReferenceId(transaction1.getReferenceId());
		response.setStatus("Success");
		return response;
		}
		
	}

}
