package com.ing.modelbank.service;

import com.ing.modelbank.pojo.FundTRansferRequest;
import com.ing.modelbank.pojo.FundTRansferResponse;

public interface FundTransferService {

	FundTRansferResponse saveTansaction(FundTRansferRequest request);

}
