package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.CustomerDetails;

/**
 * interface CustomerDetailsRepository
 * @author ING Dev Team
 *
 */
@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

	CustomerDetails findByCustomerId(String customerId);

}
