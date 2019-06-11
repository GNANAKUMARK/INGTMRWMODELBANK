/**
 * 
 */
package com.ing.modelbank.service;

import com.ing.modelbank.pojo.CustomerDetaillsResponse;

/**
 * Interface contract for CustomerDetailsService
 * 
 * @author ING Dev Team
 *
 */
public interface CustomerDetailsService {
	CustomerDetaillsResponse getCustomerDetails(String customerId);
}
