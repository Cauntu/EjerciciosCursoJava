package com.es.eoi.ejercicios0608.Diario;

import java.io.*;

public class Diario {

	public static void main(String[] args) throws NumberFormatException, IOException {

		menu();

	}

	public static void menu() throws NumberFormatException, IOException {

		int option = 0;
		String line;

		System.out.println();
		System.out.println("1 - Escribir diario");
		System.out.println("2 - Leer diario");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		option = Integer.parseInt(br.readLine());
		//br.close();

		switch (option) {

		case 1:

			System.out.println("Escriba tantas lineas como quiera o escriba FIN para salir.");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			//BufferedWriter bw = new BufferedWriter(new FileWriter("diario.txt", false));
			FileWriter fw = new FileWriter("diario.txt", true);
			try {

				while ((line = br1.readLine()).compareTo("FIN") != 0 && line != null) {

					fw.write(line);
					fw.write("\n");

				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				fw.close();
			}

//			bw.close();
//			br1.close();

			menu();
			break;

		case 2:

			try {

				BufferedReader br2 = new BufferedReader(new FileReader("diario.txt"));

				while ((line = br2.readLine()) != null) {
					System.out.println(line);
				}

			} catch (FileNotFoundException e) {
				System.out.println("El archivo no existe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				menu();
			}
			break;

		default:
			System.out.println("Opcion erronea");
			menu();
			break;
		}

	}

}
