package com.sunday.sunday.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sunday.sunday.entities.TaxRate;

@Repository
public interface TaxRateRepository extends JpaRepository<TaxRate, Long> {

	@Query(value="select state_tax from tax_rate where state = :state" , nativeQuery = true )
	public BigInteger getStateTax(@Param("state") String state); 
}
