package com.es.eoi.ejercicios3107.ej2;

public class GenerarTablero {

	private static String[][] tablero;

	public static String[][] generarTablero(int a, int b) {

		tablero = new String[a][b];

		rellenaTablero(tablero, "c", a, b);

		return tablero;
	}

	public static void rellenaTablero(String[][] tab, String contents, int a, int b) {

		if (contents.contains("c")) {
			boolean chess = true;

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {

					if (chess == true) {
						
						tab[i][j] = "X";
						chess = false;
						
					} else {
						
						tab[i][j] = "O";
						chess = true;

					}

				}
			}

		}

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {

				tab[i][j] = contents;

			}
		}

	}
}
