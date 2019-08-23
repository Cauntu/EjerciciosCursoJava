package com.es.eoi.ejMaven;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Object{

	// VARIABLES

	private String nombre;
	private String apellido;
	private int edad;
	private List<Calificacion> notas = new ArrayList<Calificacion>();

	// {GET, SET}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Calificacion> getNotas() {
		return notas;
	}

	public void setNotas(List<Calificacion> notas) {
		this.notas = notas;
	}

	// CONSTRUCTORS

	public Alumno(String nombre, String apellido, int edad, List<Calificacion> notas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.notas = notas;
	}

	// METHODS
	
	@Override
	public String toString() {
		return  "\n" + nombre + " " + apellido + "(" + edad + ")" + notas.get(0).toString() + notas.get(1).toString() + notas.get(2).toString();
	}
}
