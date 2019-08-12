package com.es.eoi.calc.app;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;

import com.es.eoi.calc.services.Operable;

public class CalculadoraLambda {

	public static void main(String[] args) {

		List<String> tablas = new ArrayList<String>();

		Operable suma = (x, y) -> {
			return x + y;
		};

		Operable resta = (x, y) -> {
			return x - y;
		};

		Operable multiplicacion = (x, y) -> {
			return x * y;
		};

		Operable division = (x, y) -> {
			return x / y;
		};

		System.out.println("Tablas de multiplicar");
		String output = "";

		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {

				output = String.valueOf(i).concat(" x ").concat(String.valueOf(j)).concat(" = ")
						.concat((multiplicacion.operation(i, j)).toString());
				// System.out.println(output);
				tablas.add(output);
			}
		}

		Stream st;
		st = tablas.stream();
		System.out.println();
		System.out.print("Numero de filas almacenadas: ");
		System.out.println(st.count());
		st.close();

		st = tablas.stream();
		System.out.println();
		System.out.print("Numero de filas que correspondes a la tabla del 3: ");
		System.out.println(st.filter(p -> ((String) p).contains("3 x")).count());
		st.close();

		st = tablas.stream();
		System.out.println();
		System.out.println("Tabla de multiplicar del 5: ");
		st.filter(p -> ((String) p).contains("5 x")).forEach(System.out::println);
		st.close();

		st = tablas.stream();
		System.out.println();
		System.out.println("Tabla de multiplicar del 5 (Invertida): ");
		st.filter(p -> ((String) p).contains("x 5")).forEach(System.out::println);
		st.close();
	}

}
