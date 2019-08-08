package com.es.eoi.Ahorcado;

import java.io.Console;
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
	private static char[] offuscatedWord;
	private static char[] word;
	private static BufferedReader userInput;

	// declaramos el tamaño de palabra y las lineas del dibujo
	private static final int wordSize = 6;
	private static final int numLines = 9;
	private static final int lives = 5;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.out.println("Pulse Intro para comenzar a jugar.");
		game();

	}

	public static void game() throws IOException, InterruptedException {

		// creamos el buffer de palabra y lo rellenamos con '_'
		offuscatedWord = new char[wordSize];
		for (int i = 0; i < offuscatedWord.length; i++) {
			offuscatedWord[i] = '_';
		}

		// creamos una lista de los caracteres usados
		usedC = new ArrayList<Character>();

		// leemos todas las palabras del diccionario
<<<<<<< HEAD
		File f = new File("C:\\Users\\Cauntu\\Desktop\\Repo\\alumnos\\BecaUlab0708\\resources\\words.txt");
=======
		File f = new File("resources/words.txt");
>>>>>>> master
		List<String> words = Files.readAllLines(f.toPath());

		// elegimos un numero al azar
		int numPalabra = ThreadLocalRandom.current().nextInt(0, words.size());

		// escogemos la palabra de dicho numero
		word = words.get(numPalabra).toCharArray();

		// nos preparamos para dibujar al ahorcado y recibir letras
		userInput = new BufferedReader(new InputStreamReader(System.in));
		userInput.read();

		for (int i = 0; i <= lives;) {

			if (!checkVictory()) {

				if (i < lives) {

					drawHangMan(i);
					writeWordState();
					writeUsed();
					Character charIn;

					do {
						System.out.println();
						System.out.print("Introduzca una letra: ");
						charIn = Character.toUpperCase(askUserInput());
					} while (!validateUserInput(charIn));

					if (!checkMatch(charIn)) {

						i++;

					}

				} else {

					drawHangMan(i);
					writeWordState();
					writeUsed();

					System.out.println();
					System.out.println("Pulse Intro para intentarlo de nuevo.");
					System.in.read();
					game();
				}

				// comprobamos si hemos perdido o ganado
				if (checkVictory()) {

					drawHangMan(i);
					writeWordState();
					writeUsed();
					i = 5;

					System.out.println();
					System.out.println("Enhorabuena, has ganado.");
					System.out.println("Pulse Intro para intentarlo de nuevo.");
					System.in.read();
					game();
				}
			}
		}
		game();

	}

	public static void drawHangMan(int state) throws IOException {

		FileReader fr = null;
		String statePath;

		switch (state) {

		case 0:

			statePath = new File("resources/ascii/hangman0.txt").getAbsolutePath();
			fr = new FileReader(statePath);

			break;

		case 1:
			
			statePath = new File("resources/ascii/hangman1.txt").getAbsolutePath();
			fr = new FileReader(statePath);
			
			break;

		case 2:
			
			statePath = new File("resources/ascii/hangman2.txt").getAbsolutePath();
			fr = new FileReader(statePath);
			
			break;

		case 3:
			
			statePath = new File("resources/ascii/hangman3.txt").getAbsolutePath();
			fr = new FileReader(statePath);
			
			break;

		case 4:
			
			statePath = new File("resources/ascii/hangman4.txt").getAbsolutePath();
			fr = new FileReader(statePath);
			
			break;

		case 5:
			
			statePath = new File("resources/ascii/hangman_full.txt").getAbsolutePath();
			fr = new FileReader(statePath);
			
			break;

		default:

			break;
		}

		BufferedReader fileInput = new BufferedReader(fr);

		for (int i = 0; i < numLines; i++) {

			System.out.println(fileInput.readLine());
		}

	}

	public static void writeWordState() {

		System.out.println();
		System.out.print("(");
		for (int i = 0; i < offuscatedWord.length; i++) {

			System.out.print(offuscatedWord[i]);
			if (i != offuscatedWord.length - 1) {
				System.out.print(" ");
			}

		}
		System.out.print(")");
	}

	public static void writeUsed() {

		System.out.print("	");
		System.out.print("Usados: [");

		for (int i = 0; i < usedC.size(); i++) {

			System.out.print(usedC.get(i));

			if (i != usedC.size() - 1) {

				System.out.print(" ");
			}
		}

		// mas formato
		System.out.print("]");

	}

	public static Character askUserInput() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		return (char) br.read();

	}

	public static Boolean validateUserInput(char input) {

		if (input == '\n' || input == '\r') {
			return false;
		}

		// descartamos el caracter si ya se usó
		for (Character c : usedC) {

			if (c == input) {
				return false;
			}
		}

		// añadimos el caracter a usados
		usedC.add(input);

		return true;

	}

	public static Boolean checkMatch(char input) {

		if (input == '\n' || input == '\r') {
			return true;
		}

		Boolean match = false;

		// comprobamos si el caracter está en la palabra
		for (int i = 0; i < word.length; i++) {

			if (input == word[i]) {

				offuscatedWord[i] = input;
				match = true;
			}

		}

		return match;

	}

	public static Boolean checkVictory() {

		for (int j = 0; j < offuscatedWord.length; j++) {

			if (offuscatedWord[j] == '_') {
				return false;
			}

		}
		return true;

	}

}
