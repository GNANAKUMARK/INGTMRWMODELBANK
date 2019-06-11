/**
 * 
 */
package com.ing.modelbank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Container for  Customer Details entity
 * @author ING Dev Team
 *
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
public class CustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountType;
	
	private String customerName;
	
	private Double balance;
	
	private String customerId;
	
	private LocalDate creationDate;
	
	

}
