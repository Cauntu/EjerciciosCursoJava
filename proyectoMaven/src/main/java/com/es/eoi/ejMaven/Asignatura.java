package com.es.eoi.ejMaven;

public class Asignatura {

	public enum NAsignaturas {
		FISICA, QUIMICA, MATEMATICAS;
	}

	private NAsignaturas nombre;

	// {GET, SET}

	public NAsignaturas getNombre() {
		return nombre;
	}

	public void setNombre(NAsignaturas nombre) {
		this.nombre = nombre;
	}

	// METHODS

	@Override
	public String toString() {

		switch (nombre) {
		case FISICA:
			return "FISICA";

		case QUIMICA:
			return "FISICA";
			
		case MATEMATICAS:
			return "MATEMATICAS";
	
		default:
			return null;
		}

	}

}
