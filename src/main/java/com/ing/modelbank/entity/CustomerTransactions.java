package com.ing.modelbank.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerTransactions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5164418731119302220L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String comments;
	private Long referenceId;
	private String status;
	private LocalDateTime date = LocalDateTime.now();
	@ManyToOne

    @JoinColumn(name = "Customer_Id")

    @JsonBackReference

    private CustomerDetails customer;
}
