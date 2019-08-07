package com.es.eoi.ejMaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.es.eoi.ejMaven.Asignatura.NAsignaturas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EjJSON {

	public static void main(String[] args) throws IOException {

		System.out.println("Bienvenido a la aplicación para profesores:");
		System.out.println("Generando JSON de calificaciones.");

		List<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno a1 = new Alumno("Pepe", "Garcia", 14, new ArrayList<Calificacion>());
		Alumno a2 = new Alumno("Fran", "Perez", 17, new ArrayList<Calificacion>());
		Alumno a3 = new Alumno("Paula", "Fernandez", 15, new ArrayList<Calificacion>());

		List<Calificacion> cals = new ArrayList<Calificacion>();
		cals.add(new Calificacion(2, NAsignaturas.FISICA));
		cals.add(new Calificacion(8, NAsignaturas.QUIMICA));
		cals.add(new Calificacion(5, NAsignaturas.MATEMATICAS));

		a1.setNotas(cals);
		a2.setNotas(cals);
		a3.setNotas(cals);

		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);

//		FileWriter fw = new FileWriter("alumnos.json", false);
//		BufferedReader br = new BufferedReader(new FileReader("alumnos.json"));
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(alumnos.toArray());
//		
//		System.out.println("---");
//		System.out.println(json);
//		System.out.println("---");
//		//write and reset vars
//		fw.write(json);
//		fw.close();
//		json = null;
//		alumnos.clear();
//
//		json = br.readLine();
//		
//		alumnos = Arrays.asList(gson.fromJson(json, Alumno[].class) );
//		for (Alumno al : alumnos) {
//			System.out.println(al.toString());
//		}
//		
//		br.close();
		
		
		FileWriter fw = new FileWriter("alumnos.json", false);
		BufferedReader br = new BufferedReader(new FileReader("alumnos.json"));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(alumnos.toArray());
		
		System.out.println("---");
		System.out.println(json);
		System.out.println("---");
		//write and reset vars
		fw.write(json);
		fw.close();
		json = null;
		alumnos.clear();

		alumnos = Arrays.asList(gson.fromJson(br, Alumno[].class) );
		//gson.fromJson(br, Alumno[].class);
		for (Alumno al : alumnos) {
			System.out.println(al.toString());
		}
		
		br.close();

	}

}
