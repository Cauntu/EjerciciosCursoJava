package com.es.eoi.ejercicios3107.ej2;

public class Meses {

	public static void main(String[] args) {

		String[] meses = new String[12];
		String[][] tab;
		int a = 5;
		int b = 5;
		
		meses[0] = "Enero";
		meses[1] = "Febrero";
		meses[2] = "Marzo";
		meses[3] = "Abril";
		meses[4] = "Mayo";
		meses[5] = "Junio";
		meses[6] = "Julio";
		meses[7] = "Agosto";
		meses[8] = "Septiembre";
		meses[9] = "Octubre";
		meses[10] = "Noviembre";
		meses[11] = "Diciembre";

		for (int i = 0; i < meses.length; i++) {
			
			System.out.println(meses[i]);
			
		}
		
		tab = GenerarTablero.generarTablero(a,b);
		
		for (int i = 0; i < a; i++) {
			System.out.println();
			for (int j = 0; j < b; j++) {

				System.out.print(tab[i][j] + " ");
			}
		}

	}

}
