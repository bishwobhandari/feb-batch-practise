package com.sunday.sunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunday.sunday.entities.FederalTax;

@Repository
public interface FederalIncomeTaxRepository extends  JpaRepository<FederalTax, Long>{

}
