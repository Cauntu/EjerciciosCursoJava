package com.es.eoi.ejercicios0508.ej1y2;

public class Persona implements Comparable<Persona> {

	private String DNI;
	private String name;
	private int age;
	private int birthdate;
	private String others;

	// {get, set}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(int birthdate) {
		this.birthdate = birthdate;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	// constructors
	public Persona(String dNI, String name, int age, int birthdate, String others) {
		super();
		DNI = dNI;
		this.name = name;
		this.age = age;
		this.birthdate = birthdate;
		this.others = others;
	}

	@Override
	public String toString() {
		return ("Persona [" + DNI + " " + name + " " + age + " " + birthdate + " " + others + "]");
	}

	@Override
	public int compareTo(Persona pers) {

		if (this.name.compareTo(pers.name) == 0) {
			if (this.age == pers.age) {

				if (this.birthdate == pers.birthdate) {
					return 0;
				} else if (this.birthdate > pers.birthdate) {
					return 1;
				} else {
					return -1;
				}

			} else if (this.age > pers.age) {
				return 1;
			} else {
				return -1;
			}

		} else if (this.name.compareTo(pers.name) < 1) {
			return 1;
		} else {
			return -1;
		}
	}

}
