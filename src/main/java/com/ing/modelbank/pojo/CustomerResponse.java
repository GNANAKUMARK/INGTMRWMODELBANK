package com.ing.modelbank.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2558685189831448438L;

	private String customerId;
	
	private String customerName;
	
}
