package com.ing.modelbank.service;

import java.util.List;
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

	private static final Random random = new Random();
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
		
		Long referenceId = (long) (10000000 + random.nextInt(900000));
		transaction.setReferenceId(referenceId);
		CustomerTransactions transaction1=repository.save(transaction);
		detail.setBalance(detail.getBalance()-transaction.getAmount());
		repo.save(detail);
		
		List<CustomerDetails> list = repo.findAll();
		for (CustomerDetails customerDetails : list) {
			if(customerDetails.getCustomerId().equalsIgnoreCase(request.getBeneficiaryId())) {
				Double amount =customerDetails.getBalance()+transaction.getAmount();
			
				customerDetails.setBalance(amount);
				repo.save(customerDetails);
			}
		}
		response.setReferenceId(transaction1.getReferenceId());
		response.setStatus("Success");
		return response;
		}
		
	}

	

}
