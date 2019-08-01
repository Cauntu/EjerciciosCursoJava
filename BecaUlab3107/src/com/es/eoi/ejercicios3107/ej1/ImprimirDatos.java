package com.es.eoi.ejercicios3107.ej1;

public class ImprimirDatos {

	public static void main(String[] args) {

		TipoDatos datos1 = new TipoDatos();

		System.out.println(
		"Hola me llamo " + datos1.name + " " + datos1.surname + " y tengo " + datos1.age + " anyos.");
		
		System.out.println(
		"Nací el " + datos1.day + "/" + datos1.month + "/" + datos1.year + " y vivo en " + datos1.city + ".");
	}

	public static void imprimirTodos(TipoDatos[] td) {

		for (int i = 0; i < td.length; i++) {

			System.out.println(td[i].name);

		}

	}
}
