package com.es.eoi.ejercicios0108.ej2y3;

import java.util.Random;

public class AnimalesDomesticos {

	public static void main(String[] args) {

		Animal[] mascotas = new Animal[15];
		Perro[] perros = new Perro[5];
		Gato[] gatos = new Gato[5];
		Raton[] ratones = new Raton[5];

		almacenaMascotas(perros, 'p');
		almacenaMascotas(gatos, 'g');
		almacenaMascotas(ratones, 'r');

		empaquetaMascotas(mascotas, perros, gatos, ratones);

		muestraMascotas(mascotas);
	}

	private static void almacenaMascotas(Animal[] Container, char type) {

		Random r = new Random();

		if (Container.getClass() == Perro[].class) {

			for (int i = 0; i < Container.length; i++) {
				Container[i] = new Perro("nPerro" + (i + 1), r.nextFloat()*3, r.nextFloat()*3);

			}
		}

		if (Container.getClass() == Gato[].class) {

			for (int i = 0; i < Container.length; i++) {
				Container[i] = new Gato("nGato" + (i + 1), r.nextFloat()*2, r.nextFloat()*2);

			}

		}

		if (Container.getClass() == Raton[].class) {

			for (int i = 0; i < Container.length; i++) {
				Container[i] = new Raton("nRaton" + (i + 1), r.nextFloat(), r.nextFloat());

			}
		}

	}

	private static void empaquetaMascotas(Animal[] mascotas, Animal[] perros, Animal[] gatos, Animal[] ratones) {

		for (int i = 0; i < mascotas.length; i++) {
			// añadimos los perros
			for (int j = 0; j < perros.length; j++) {
				mascotas[i] = perros[j];
				i++;
			}
			// añadimos los gatos
			for (int j = 0; j < gatos.length; j++) {
				mascotas[i] = gatos[j];
				i++;
			}
			// añadimos los ratones
			for (int j = 0; j < ratones.length; j++) {
				mascotas[i] = ratones[j];
				i++;
			}
		}

	}

	private static void muestraMascotas(Animal[] mascotas) {

		Animal mayor = new Animal(null, 0, 0);

		for (int i = 0; i < mascotas.length; i++) {

			if (mascotas[i].getWeight() > mayor.getWeight()) {

				mayor.setName(mascotas[i].getName());
				mayor.setWeight(mascotas[i].getWeight());
			}

			System.out.println(mascotas[i].getName() + " es un " + mascotas[i].getSpecies() + ", pesa "
					+ mascotas[i].getWeight() + " y mide " + mascotas[i].getHeight());

		}
		
		System.out.println("El animal más pesado es " + mayor.getName() + " y pesa " + mayor.getWeight() + " kg.");

	}
}
