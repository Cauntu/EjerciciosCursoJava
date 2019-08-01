package training.es.dddr.ej6;

import java.util.Scanner;

public class Api {

	public static void main(String[] args) {

		final String pw = "pAsSw0rD";
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduzca su contraseña");
		while(!(scan.next()).equals(pw))
		{
			System.out.println("Intentalo otra vez");
		}
		
		System.out.println("¡Correcto!");
	}

}
