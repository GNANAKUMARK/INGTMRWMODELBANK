/**
 * 
 */
package com.ing.modelbank.service;

import com.ing.modelbank.entity.CustomerTransactions;

/**
 * Interface contract for CustomerDetailsService
 * @author ING Dev Team
 *
 */
public interface TransactionDetailsService {
	CustomerTransactions getTransactionDetailsForId(Long id);
}
