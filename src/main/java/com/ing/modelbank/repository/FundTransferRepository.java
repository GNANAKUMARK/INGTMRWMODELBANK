package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.CustomerTransactions;

@Repository
public interface FundTransferRepository extends JpaRepository<CustomerTransactions, Long>{
	@Query(value = "select * from customer_transactions where reference_id =?1",nativeQuery = true)

    CustomerTransactions findRequestById(Long id);
}
