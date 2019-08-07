package com.es.eoi.Ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {

	private static List<Character> usedC;
	private static char[] chars;

	// declaramos el tamaño de palabra y las lineas del dibujo
	private static final int wordSize = 6;
	private static final int numLines = 9;

	public static void main(String[] args) throws InterruptedException, IOException {

		// new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		game();

	}

	public static void game() throws IOException {

		// creamos el buffer de palabra y lo rellenamos con '_'
		chars = new char[wordSize];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = '_';
		}

		// creamos una lista de los caracteres usados
		usedC = new ArrayList<Character>();

		// leemos todas las palabras del diccionario
		File f = new File("words.txt");
		List<String> words = Files.readAllLines(f.toPath());

		// elegimos un numero al azar
		int numPalabra = ThreadLocalRandom.current().nextInt(0, words.size());

		// escogemos la palabra de dicho numero
		char[] word = words.get(numPalabra).toCharArray();

		// nos preparamos para dibujar al ahorcado y recibir letras
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		FileReader state0 = new FileReader("hangman0.txt");
		FileReader state1 = new FileReader("hangman1.txt");
		FileReader state2 = new FileReader("hangman2.txt");
		FileReader state3 = new FileReader("hangman3.txt");
		FileReader state4 = new FileReader("hangman4.txt");
		FileReader state5 = new FileReader("hangman_full.txt");

		drawHangMan(state0);
		writeWordState();
		writeUsed();

	}

	public static void drawHangMan(FileReader fr) throws IOException {

		BufferedReader fileInput = new BufferedReader(fr);

		for (int i = 0; i < numLines; i++) {

			System.out.println(fileInput.readLine());
		}

	}

	public static void writeWordState() {

		System.out.println();
		System.out.print("(");
		for (int i = 0; i < chars.length; i++) {

			System.out.print(chars[i]);
			if (i != chars.length - 1) {
				System.out.print(" ");
			}

		}
		System.out.print(")");
	}

	public static void writeUsed() {

		System.out.print("	");
		System.out.print("Usados: [");
		for (Character c : usedC) {
			System.out.print(c + " ");
		}

		// mas formato
		System.out.print("]");

	}

}
