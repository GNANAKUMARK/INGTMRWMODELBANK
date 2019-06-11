/**
 * 
 */
package com.ing.modelbank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private static final long serialVersionUID = -9141521724692318798L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountType;
	
	private String customerName;
	
	private Double balance;
	
	private String customerId;
	
	private LocalDate creationDate;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
    @JsonManagedReference
    private  List<CustomerTransactions> transactions;
	
	

}
