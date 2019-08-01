package com.es.eoi.ejercicios0108.ej2y3;

public class Raton extends Animal {

	private final String species = "raton";

	public Raton(String name, float weight, float height) {
		super(name, weight, height);
	}

	@Override
	public String getSpecies() {
		return species;
	}

	@Override
	public void sound() {
		System.out.println("Eek");
	}
}
