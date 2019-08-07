package com.es.eoi.ejMaven;

import com.es.eoi.ejMaven.Asignatura.NAsignaturas;

public class Calificacion {

	private double nota;
	private NAsignaturas asignatura;

	// {GET, SET}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public NAsignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(NAsignaturas asignatura) {
		this.asignatura = asignatura;
	}

	// CONSTRUCTORS

	public Calificacion(double nota, NAsignaturas asignatura) {
		super();
		this.nota = nota;
		this.asignatura = asignatura;
	}

	// METHODS

	@Override
	public String toString() {
		return "\n" + asignatura.toString() + " : " + nota ;
	}

}
