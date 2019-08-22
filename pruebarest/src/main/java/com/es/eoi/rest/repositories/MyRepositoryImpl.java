package com.es.eoi.rest.repositories;

import org.springframework.stereotype.Repository;

import com.es.eoi.rest.interfaces.MyRepository;


@Repository
public class MyRepositoryImpl implements MyRepository{

	public String saluda() {
		
		return "Hola";
	}
	
}
