package com.es.eoi.ejercicios0508.ejString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjString {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Esto es una prueba";
		String str2 = "La clase String, tiene varios métodos, muy útiles, como saber su longitud, trocear la cadena, etc";
		String str3 = "Esto es un ejemplo usado para determinar un indice";

		System.out.println("Apartado 1: ");
		System.out.println(str1.toUpperCase());
		System.out.println();

		System.out.println("Apartado 2: ");
		String[] toks = str2.split(",");
		for (int i = 0; i < toks.length; i++) {
			System.out.println(toks[i]);
		}
		System.out.println();

		System.out.println("Apartado 3: ");
		System.out.println("Índice de " + '"' + "ejemplo" + '"' + "=" + str3.indexOf("ejemplo"));
		System.out.println();

		System.out.println("Apartado 4: ");
		String str4 = "324-1-1994";
		String str5 = "02/09/1994";
		String str6 = "02-09-1994";

		if (pruebaRegex(str4)) {
			System.out.println("str4 = " + str4 + " LEGIBLE");
		} else {
			System.out.println("str4 = " + str4 + " NO LEGIBLE");
		}

		if (pruebaRegex(str5)) {
			System.out.println("str5 = " + str5 + " LEGIBLE");
		} else {
			System.out.println("str5 = " + str5 + " NO LEGIBLE");
		}

		if (pruebaRegex(str6)) {
			System.out.println("str6 = " + str6 + " LEGIBLE");
		} else {
			System.out.println("str6 = " + str6 + " NO LEGIBLE");
		}
		System.out.println();
		
		System.out.println("Apartado 5: ");
		System.out.println("Esperando entrada: ");
		
		Scanner sc = new Scanner(System.in);
		String strUser = (sc.nextLine()).toLowerCase();
		sc.close();
		
		Integer nA = 0;
		Integer nE = 0;
		Integer nI = 0;
		Integer nO = 0;
		Integer nU = 0;

		for (int i = 0; i < strUser.length(); i++) {
			
			switch (strUser.charAt(i)) {
			case 'a':
				nA++;
				break;
				
			case 'e':
				nE++;
				break;

			case 'i':
				nI++;
				break;

			case 'o':
				nO++;
				break;

			case 'u':
				nU++;
				break;

			default:
				break;
			}
			
		}
		
		System.out.println("Ocurrencias: " + "A: " + nA + " E: " + nE + " I: " + nI + " O: " + nO + " U: " + nU);

	}

	public static Boolean pruebaRegex(String target) {

		Pattern pat = Pattern.compile("[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]");
		Matcher mat = pat.matcher(target);

		if (mat.matches()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
