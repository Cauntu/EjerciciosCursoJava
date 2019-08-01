package com.es.eoi.ejercicios0108.ej2y3;

public class Gato extends Animal {

	private final String species = "gato";

	public Gato(String name, float weight, float height) {
		super(name, weight, height);
	}
	
	@Override
	public String getSpecies() {
		return species;
	}
	
	@Override
	public void sound() {
		System.out.println("Meow");
	}

}
