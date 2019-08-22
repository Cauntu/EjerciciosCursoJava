package com.es.eoi.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.es.eoi.interfaces.MyService;
import com.es.eoi.interfaces.Alumno;

@Controller
public class MyController {
	
	@Autowired
	private static MyService<Alumno> service;
	
	
}

