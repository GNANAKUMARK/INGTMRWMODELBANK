package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferRepository extends JpaRepository<Integer, Integer>{

}
