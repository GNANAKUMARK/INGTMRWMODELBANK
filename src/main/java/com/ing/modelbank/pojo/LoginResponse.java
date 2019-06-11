package com.ing.modelbank.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5335934519706969811L;

	private String customerId;
	
	private String status;

}
