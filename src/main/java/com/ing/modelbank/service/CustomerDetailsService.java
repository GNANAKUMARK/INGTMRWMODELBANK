/**
 * 
 */
package com.ing.modelbank.service;

import java.util.List;

import com.ing.modelbank.entity.CustomerDetails;
import com.ing.modelbank.pojo.CustomerDetaillsResponse;

/**
 * Interface contract for CustomerDetailsService
 * 
 * @author ING Dev Team
 *
 */
public interface CustomerDetailsService {
	CustomerDetaillsResponse getCustomerDetails(String customerId);

	List<CustomerDetails> getBeneficiariesDetails(String customerId);

	List<CustomerDetails> findByAll();
	
}
