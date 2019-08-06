package com.es.eoi.ejercicios0508.ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.es.eoi.ejercicios0508.ej3.StudentGrade.Grade;

public class MENU {

	private static List<StudentGrade> students = new ArrayList<StudentGrade>();

	public enum MenuOption {

		NEW_GRADE, LIST_GRADES, LIST_GRADESUP, LIST_GRADESDOWN, LIST_A, LIST_B, LIST_C, LIST_D, LIST_E;

	}

	public static void main(String[] args) {

		System.out.println("Bienvenido a la aplicación para profesores:");
		listMenu();

	}

	public static void listMenu() {

		System.out.println();
		System.out.println("1: Nueva nota 2: Listar notas 3: Listar notas(ascendente)");
		System.out.println("4: Listar notas(descendente) 5: Listar Sobresalientes 6: Listar Notables");
		System.out.println("7: Listar Bien 8: Listar Suficientes 9: Listar Insuficientes");

		System.out.print("Introduzca una opción: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;
		try {
			userInput = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			// TODO: handle exception
		}

		switch (userInput) {
		case 1:
			doSomething(MenuOption.NEW_GRADE);
			break;

		case 2:
			doSomething(MenuOption.LIST_GRADES);
			break;

		case 3:
			doSomething(MenuOption.LIST_GRADESUP);
			break;

		case 4:
			doSomething(MenuOption.LIST_GRADESDOWN);
			break;

		case 5:
			doSomething(MenuOption.LIST_A);
			break;

		case 6:
			doSomething(MenuOption.LIST_B);
			break;

		case 7:
			doSomething(MenuOption.LIST_C);
			break;

		case 8:
			doSomething(MenuOption.LIST_D);
			break;

		case 9:
			doSomething(MenuOption.LIST_E);
			break;

		default:
			System.out.println();
			System.out.println("Opción incorrecta. Inténtelo de nuevo");
			listMenu();
			break;
		}

	}

	public static void doSomething(MenuOption o) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		switch (o) {

		case NEW_GRADE:

			String n = null;
			int g = 0;

			System.out.print("Introduzca el nombre del alumno: ");
			try {
				n = br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
			}

			System.out.print("Introduzca la nota del alumno: ");
			try {
				g = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				// TODO: handle exception
			}

			StudentGrade nAlumno = new StudentGrade(n, g);
			students.add(nAlumno);

			System.out.println();
			System.out.println("Estudiante añadido");
			listMenu();

			break;

		case LIST_GRADES:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_GRADESUP:

			if (!students.isEmpty()) {

				Collections.sort(students);

				for (StudentGrade sG : students) {
					System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_GRADESDOWN:

			if (!students.isEmpty()) {

				Collections.sort(students, Comparator.reverseOrder());

				for (StudentGrade sG : students) {
					System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_A:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					if (sG.getTextGrade() == Grade.SOBRESALIENTE)
						System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_B:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					if (sG.getTextGrade() == Grade.NOTABLE)
						System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_C:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					if (sG.getTextGrade() == Grade.BIEN)
						System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_D:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					if (sG.getTextGrade() == Grade.SUFICIENTE)
						System.out.println(sG.toString());
				}

			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		case LIST_E:

			if (!students.isEmpty()) {

				for (StudentGrade sG : students) {
					if (sG.getTextGrade() == Grade.INSUFICIENTE)
						System.out.println(sG.toString());
				}
			} else {
				System.out.println("Lista vacia");
			}
			listMenu();
			break;

		default:
			break;
		}

	}

}
