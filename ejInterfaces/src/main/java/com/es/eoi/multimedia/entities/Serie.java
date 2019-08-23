package com.es.eoi.multimedia.entities;

import com.es.eoi.multimedia.interfaces.Capituleable;
import com.es.eoi.multimedia.interfaces.Reproducible;

public class Serie implements Reproducible, Capituleable {

	private String nombre;
	private String estado;

	private int numCapitulos;
	private int capituloActual;

	// {GET, SET}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumCapitulos() {
		return numCapitulos;
	}

	public void setNumCapitulos(int numCapitulos) {
		this.numCapitulos = numCapitulos;
	}

	public int getcapituloActual() {
		return capituloActual;
	}

	public void setcapituloActual(int capActual) {
		this.capituloActual = capActual;
	}

	// CONSTRUCTORS

	public Serie(String nombre, int numCapitulos) {
		super();
		this.nombre = nombre;
		this.estado = "STOP";
		this.capituloActual = 1;
		this.numCapitulos = numCapitulos;
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

	public void next() {
		if (this.capituloActual < this.numCapitulos) {
			this.capituloActual++;
		} else {
			System.out.println("No hay más capitulos");
		}
	}

	public void previous() {
		
		if (this.capituloActual > 1) {
			this.capituloActual--;
		} else {
			System.out.println("No hay más capitulos");
		}
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
		return this.nombre.concat(" ").concat(estado).concat(" ").concat("capitulo: ") + capituloActual;
	}

}
