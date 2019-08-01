package com.es.eoi.ejercicios3107.ej3;

public class Formulas {

	public static void main(String[] args) {
		
		Float a = Float.valueOf(args[0]);
		Float b = Float.valueOf(args[1]);
		Float c = Float.valueOf(args[2]);
		Float d = Float.valueOf(args[3]);
		
		
		float result = (a/b) * (c/d);
		
		System.out.println(result);

	}

}
