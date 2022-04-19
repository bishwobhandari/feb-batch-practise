package com.sunday.sunday.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //for getter and setter
@NoArgsConstructor //for default constructor
@AllArgsConstructor //for all argument constructor
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String country;
	
	

}
