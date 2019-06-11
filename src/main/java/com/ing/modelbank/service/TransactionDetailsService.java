/**
 * 
 */
package com.ing.modelbank.service;

import java.util.List;

import com.ing.modelbank.entity.CustomerTransactions;

/**
 * Interface contract for CustomerDetailsService
 * @author ING Dev Team
 *
 */
public interface TransactionDetailsService {
	CustomerTransactions getTransactionDetailsForId(Long id);

	List<CustomerTransactions> getTransactionDetailsforId(Long customer_Id);
}
