package com.es.eoi.ejercicios3107.ej2;

public class GenerarTablero {

	private static char[][] tablero;

	public static char[][] generarTablero(int a, int b) {

		tablero = new char[a][b];

		rellenaTablero(tablero, 'c');

		return tablero;
	}

	public static void rellenaTablero(char[][] tab, char content) {

		int col = tab.length;
		int row = tab[0].length;

		if (content == 'c') {
			boolean chess = true;

			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {

					if (chess == true) {

						tab[i][j] = 'X';
						chess = false;

					} else {

						tab[i][j] = 'O';
						chess = true;

					}

				}
			}

		} else {

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {

					tab[i][j] = content;

				}
			}

		}

	}
}
