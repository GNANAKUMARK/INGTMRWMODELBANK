package com.ing.modelbank.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest implements Serializable{
	
	private String customerId;
	
	private String password;
	

}
