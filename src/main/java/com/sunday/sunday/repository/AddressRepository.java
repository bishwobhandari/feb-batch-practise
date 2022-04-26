package com.sunday.sunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunday.sunday.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	
}
