package com.es.eoi.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.eoi.rest.interfaces.MyRepository;
import com.es.eoi.rest.interfaces.MyService;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyRepository repository;

	public String saluda() {
		return this.repository.saluda();
	}
}
