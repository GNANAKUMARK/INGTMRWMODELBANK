package com.ing.modelbank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerTransactions implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String comments;
	private Long referenceId;
	private LocalDate date = LocalDate.now();
}
