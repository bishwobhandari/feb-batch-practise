package com.sunday.sunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunday.sunday.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
	User findByUsername(String username); //select username from user where username='';

}
