/**
 * 
 */
package com.ing.modelbank.pojo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Container for Customer Details Response
 * 
 * @author ING Dev Team
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class CustomerDetaillsResponse implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -642545781407926285L;

	private Long id;

	private String accountType;

	private String customerName;

	private Double balance;

	private String customerId;

	private LocalDate creationDate;

}
