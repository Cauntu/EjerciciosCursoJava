package com.es.eoi.multimedia.entities;

import com.es.eoi.multimedia.interfaces.Reproducible;

public class Pelicula implements Reproducible {

	// ATRIBUTES

	private String nombre;
	private String estado;

	// {GET, SET}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// CONSTRUCTORS

	public Pelicula(String nombre) {
		this.nombre = nombre;
		this.estado = "STOP";
	}

	// METHODS

	public void play() {
		System.out.println("Arrancando ".concat(this.nombre).concat(" en 3, 2, 1..."));
		
		this.estado = "PLAY";
	}

	public void stop() {
		System.out.println("Parando ".concat(this.nombre).concat(" en 3, 2, 1..."));
		
		this.estado = "STOP";
	}

	public void pause() {
		System.out.println("Pausando ".concat(this.nombre));

		this.estado = "PAUSE";
	}
	
	public boolean isPlaying() {
		return "PLAY".equals(this.estado);
	}

	public boolean isPaused() {
		return "PAUSE".equals(this.estado);
	}

	public boolean isStopped() {
		return "STOP".equals(this.estado);
	}

	@Override
	public String toString() {
		return this.nombre.concat(" ").concat(estado) ; 
	}

}
