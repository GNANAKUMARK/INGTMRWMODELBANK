package com.ing.modelbank.pojo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundTRansferRequest {
	
	private String customerId;
	private String beneficiaryId;
	private Double amount;
	private String remarks;
	private LocalDate date;
}
