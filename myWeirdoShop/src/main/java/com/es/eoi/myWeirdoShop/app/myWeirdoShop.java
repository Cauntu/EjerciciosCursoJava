package com.es.eoi.myWeirdoShop.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.es.eoi.myWeirdoShop.entities.Article;
import com.es.eoi.myWeirdoShop.entities.Article.Category;
import com.es.eoi.myWeirdoShop.services.ArticleService;
import com.es.eoi.myWeirdoShop.services.ArticleServiceImpl;

public class myWeirdoShop {
		
	static ArticleService myArticleService;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		myArticleService = new ArticleServiceImpl();
		mainMenu(false);
	}

	public static void mainMenu(boolean retry) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;

		if (!retry) {
			System.out.println("Bienvenido a PRODUCTATOR V.1.0");
		} else {
			System.out.println("Hubo un error con su seleccion...");
		}

		System.out.println("Seleccione una de las opciones: ");
		System.out.println("1 - Nuevo Producto");
		System.out.println("2 - Listado de Productos");
		System.out.println("3 - Buscar Producto");
		System.out.println("4 - Modificar Producto");
		System.out.println("5 - Eliminar Producto");
		System.out.println("6 - Vender Producto");
		System.out.println("7 - Super Informe Ejecutivo");

		userInput = Integer.parseInt(br.readLine());

		switch (userInput) {
		case 1:
			newProductMenu(false);
			break;

		default:
			mainMenu(true);
			break;

		}
	}

	public static void newProductMenu(boolean retry) throws IOException {

		String npName = null;
		String npDesc = null;
		float npPrice = Float.parseFloat("0.00");
		int npStock = 0;
		Category npCat = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println();

		if (retry) {
			System.out.println("Hubo un error");
		}

		System.out.println("Introduzca la categoria del producto (al menos 3 caracteres)");
		System.out.println("GROCERIES MECH MATERIALS LUXURY");
		userInput = br.readLine();

		if (userInput != null && userInput.length() >= 3) {

			if ("GROCERIES".contains(userInput.toUpperCase())) {
				npCat = Category.GROCERIES;
				
			} else if ("MECH".contains(userInput.toUpperCase())) {
				npCat = Category.MECH;
				
			} else if ("MATERIALS".contains(userInput.toUpperCase())) {
				npCat = Category.MATERIALS;
				
			} else if ("LUXURY".contains(userInput.toUpperCase())) {
				npCat = Category.LUXURY;
				
			} else {
				newProductMenu(true);
			}

		} else {
			newProductMenu(true);
		}

		System.out.println("Introduzca un nombre de producto (max 15 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 15) {
			npName = userInput;
		} else {
			newProductMenu(true);
		}

		System.out.println("Introduzca una descripcion de producto (max 30 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 30) {
			npDesc = userInput;
		} else {
			newProductMenu(true);
		}

		System.out.print("Introduzca un precio para el producto: ");
		userInput = br.readLine();

		if (userInput != null && Float.parseFloat(userInput) >= 0.01) {
			npPrice = Float.parseFloat(userInput);
		} else {
			newProductMenu(true);
		}

		System.out.println();
		System.out.print("Introduzca el stock disponible: ");
		userInput = br.readLine();

		if (userInput != null && Integer.parseInt(userInput) >= 0) {
			npStock = Integer.parseInt(userInput);
		} else {
			newProductMenu(true);
		}

		
		if(myArticleService.create(new Article(npName, npDesc, npPrice, npCat, npStock) ) ) {
			mainMenu(false);
		} else {
			newProductMenu(true);
		}

	}

	public static void listProductMenu(boolean retry) {

	}

	public static void searchProductMenu(boolean retry) {

	}

	public static void editProductMenu(boolean retry) {

	}

	public static void deleteProductMenu(boolean retry) {

	}

	public static void sellProductMenu(boolean retry) {

	}

	public static void executiveReportMenu(boolean retry) {

	}

}
