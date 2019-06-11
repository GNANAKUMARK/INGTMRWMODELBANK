package com.ing.modelbank.repository;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Customer;

@Repository
@NamedQuery( name="findByCustomerIdAndPassword ", query =  "select * from customer where customer_id=:customer_id ")
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByCustomerIdAndPassword(String customerId, String password);

}
