package com.es.eoi.ejercicios0108.ej2y3;

public class Animal {

	protected String name;
	protected float weight;
	protected float height;
	protected String species = "unknown";

	public Animal(String name, float weight, float height) {

		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

	public String getSpecies() {
		return species;
	}

	public void sound() {
	}
}
