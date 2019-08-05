package com.es.eoi.ejercicios0508.ej1y2;

import java.util.Arrays;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona p1 = new Persona("DNI1", "Ana", 26, 2010, "args");
		Persona p2 = new Persona("DNI2", "Alba", 21, 1998, "args");
		Persona p3 = new Persona("DNI3", "Ana", 26, 2009, "args");
		Persona p4 = new Persona("DNI4", "Alba", 26, 2007, "args");
		Persona[] pers = { p1, p2, p3, p4 };
		
		List<Persona> listaP = Arrays.asList(pers);
		pers = null;
		
		HashMap<String, Persona> hm = new HashMap<String, Persona>();
		hm.put(p1.getDNI(), p1);
		hm.put(p2.getDNI(), p2);
		hm.put(p3.getDNI(), p3);
		hm.put(p4.getDNI(), p4);
		
		
//		
//		Collections.sort(listaP);
		for (Persona p : listaP) {
			
			//System.out.println(p);
			System.out.println(hm.get(p.getDNI()).toString());
			
		}

		
	}

}
