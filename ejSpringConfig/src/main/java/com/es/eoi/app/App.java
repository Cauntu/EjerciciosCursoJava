package com.es.eoi.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.es.eoi.interfaces.Alumno;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		MyController cont = context.getBean("controller1", MyController.class);
		
		
		
		Alumno al = context.getBean("alu", Alumno.class);
		al.setNombre("lalal");
		System.out.println(al.getNombre());
		
		
	}

}
