package com.es.eoi.myWeirdoShop.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.es.eoi.myWeirdoShop.entities.Article;
import com.es.eoi.myWeirdoShop.entities.Article.Category;
import com.es.eoi.myWeirdoShop.services.ArticleService;
import com.es.eoi.myWeirdoShop.services.ArticleServiceImpl;

public class myWeirdoShop {

	static ArticleService myArticleService;
	static List<Article> articles;

	public static void main(String[] args) {

		myArticleService = new ArticleServiceImpl();
		articles = new ArrayList<Article>();

		try {
			mainMenu(false);

		} catch (IOException e) {
			System.out.println("Ha ocurrido un error critico en la aplicacion.");
			System.out.println("Intente ejecutar la aplicacion con permisos de administrador.");
		}

	}

	public static void mainMenu(boolean retry) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;

		System.out.println();
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

		try {
			userInput = Integer.parseInt(br.readLine());

		} catch (NumberFormatException e) {
			mainMenu(true);
		}

		switch (userInput) {
		case 1:
			newProductMenu(false);
			break;

		case 2:
			listProductMenu(false);
			break;

		case 3:
			searchProductMenu(false);
			;
			break;

		case 4:
			editProductMenu(false);
			;
			break;

		case 5:
			deleteProductMenu(false);
			break;

		case 6:
			sellProductMenu(false);
			break;

		case 7:
			executiveReportMenu(false);
			break;

		default:
			mainMenu(true);
			break;

		}

	}

	public static void newProductMenu(boolean retry) throws IOException {

		String npName = null;
		String npDesc = null;
		Float npPrice = Float.parseFloat("0.00");
		Integer npStock = 0;
		Category npCat = null;

		System.out.println();

		if (retry) {
			System.out.println("Hubo un error");
		}

		if ((npCat = askCat()) != Category.NONE) {

			if ((npName = askName()) != null) {

				if ((npDesc = askDesc()) != null) {

					if ((npPrice = askPrice()) != null) {

						if ((npStock = askStock()) != null) {

							if (myArticleService.create(new Article(npName, npDesc, npPrice, npCat, npStock))) {
								System.out.println();
								System.out.println("Articulo creado con éxito.");
								System.out.println();
								mainMenu(false);
							} else {
								newProductMenu(true);
							}

						}

					}

				}
			}

		} else {
			newProductMenu(true);
		}
		newProductMenu(true);

	}

	public static void listProductMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();

		System.out.println("Listando productos...");
		System.out.println();
		articles = myArticleService.readAll();

		if (articles != null) {

			for (Article a : articles) {
				System.out.println("-----");
				System.out.println(a.toString());
				System.out.println();

			}

			mainMenu(false);

		} else {
			System.out.println("No hay articulos.");
			mainMenu(false);
		}

	}

	public static void searchProductMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll();
		String barCode;

		if ((barCode = askBarCode()) != null) {

			if (articles != null) {

				for (Article a : articles) {

					if (barCode.equals(a.getBarCode())) {
						System.out.println(a.toString());
						mainMenu(false);
					}

				}

			} else {
				System.out.println("No hay productos");
				mainMenu(false);
			}

		} else {
			searchProductMenu(true);
		}

	}

	public static void editProductMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll();

		String barCode;
		String epName = null;
		String epDesc = null;
		Float epPrice = Float.parseFloat("0.00");
		Integer epStock = 0;
		Category epCat = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		if (retry) {
			System.out.println("Hubo un error");
		}

		if ((barCode = askBarCode()) != null) {

			if (articles != null) {

				for (Article a : articles) {

					if (barCode.equals(a.getBarCode())) {

						System.out.println("Campos: Nombre(N), Descripcion(D), Precio(P), Categoria(C), Stock(S)");
						System.out.println("Introduzca el campo que desea editar");
						userInput = br.readLine();

						switch (userInput.toUpperCase()) {
						case "N":
							if ((epName = askName()) != null) {

								if (myArticleService.update(new Article(a.getBarCode(), epName, a.getDescription(),
										a.getPrice(), a.getCat(), a.getnAvailable()))) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						case "D":
							if ((epDesc = askDesc()) != null) {

								if (myArticleService.update(new Article(a.getBarCode(), a.getName(), epDesc,
										a.getPrice(), a.getCat(), a.getnAvailable()))) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						case "P":
							if ((epPrice = askPrice()) != null) {

								if (myArticleService.update(new Article(a.getBarCode(), a.getName(), a.getDescription(),
										epPrice, a.getCat(), a.getnAvailable()))) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						case "C":
							if ((epCat = askCat()) != null) {

								if (myArticleService.update(new Article(a.getBarCode(), a.getName(), a.getDescription(),
										a.getPrice(), epCat, a.getnAvailable()))) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						case "S":
							if ((epStock = askStock()) != null) {

								if (myArticleService.update(new Article(a.getBarCode(), a.getName(), a.getDescription(),
										a.getPrice(), a.getCat(), epStock))) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						default:
							editProductMenu(true);
							break;
						}

					}
				}
			} else {
				System.out.println("No hay articulos");
				mainMenu(false);
			}

		} else {
			editProductMenu(true);
		}

	}

	public static void deleteProductMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll();

		String barCode;

		if ((barCode = askBarCode()) != null) {

			for (Article a : articles) {
				if (barCode.equals(a.getBarCode())) {

					if (myArticleService.delete(barCode)) {
						System.out.println("Articulo borrado con exito");
						mainMenu(false);
					} else {
						System.out.println("Error al borrar");
					}

				}
				
			}
			System.out.println("No se ha encontrado ningun articulo con ese codigo de barras");
			deleteProductMenu(true);
			
		} else {
			deleteProductMenu(true);
		}
	}

	public static void sellProductMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		String barCode;

		if ((barCode = askBarCode()) != null) {

			if (articles != null) {

				for (Article a : articles) {

					if (barCode.equals(a.getBarCode())) {

						System.out.println("Introduzca el numero de articulos");
						userInput = br.readLine();

						if (a.getnAvailable() > Integer.parseInt(userInput)) {
							a.setnAvailable(a.getnAvailable() - Integer.parseInt(userInput));
							a.setnSold(a.getnSold() + Integer.parseInt(userInput));

						}

						if (myArticleService.update(a)) {
							System.out.println("Exito");
							mainMenu(false);
						}
					}
				}
			}
		}

	}

	public static void executiveReportMenu(boolean retry) throws IOException {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll();

		System.out.println("Generando informe...");

		if (articles != null) {

			report(Category.GROCERIES);
			report(Category.LUXURY);
			report(Category.MATERIALS);
			report(Category.MECH);
			System.out.println();
			System.out.println("FIN");
			mainMenu(false);

		} else {
			System.out.println("No hay articulos");
			mainMenu(false);
		}

	}

	public static Category askCat() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca la categoria del producto (al menos 3 caracteres)");
		System.out.println("GROCERIES MECH MATERIALS LUXURY");
		userInput = br.readLine();

		if (userInput != null && userInput.length() >= 3) {

			if ("GROCERIES".contains(userInput.toUpperCase())) {
				return Category.GROCERIES;

			} else if ("MECH".contains(userInput.toUpperCase())) {
				return Category.MECH;

			} else if ("MATERIALS".contains(userInput.toUpperCase())) {
				return Category.MATERIALS;

			} else if ("LUXURY".contains(userInput.toUpperCase())) {
				return Category.LUXURY;

			}
			return Category.NONE;

		} else {
			return Category.NONE;
		}

	}

	public static String askName() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca un nombre de producto (max 15 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 15) {
			return userInput;

		} else {
			return null;
		}
	}

	public static String askDesc() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca una descripcion de producto (max 30 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 30) {
			return userInput;

		} else {
			return null;
		}
	}

	public static Float askPrice() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("Introduzca un precio para el producto: ");
		userInput = br.readLine();

		if (userInput != null && Float.parseFloat(userInput) >= 0.01) {
			return Float.parseFloat(userInput);

		} else {
			return null;
		}
	}

	public static Integer askStock() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("Introduzca el stock disponible: ");
		userInput = br.readLine();

		if (userInput != null && Integer.parseInt(userInput) >= 0) {
			return Integer.parseInt(userInput);

		} else {
			return null;
		}
	}

	public static String askBarCode() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca el codigo de barras del producto (4 digitos)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() == 4) {
			return userInput;

		} else {
			return null;
		}
	}

	public static void report(Category cat) {

		articles = new ArrayList<Article>();
		articles = myArticleService.readAll(cat);

		Float billed = Float.parseFloat("0");
		Float total = Float.parseFloat("0");
		Float TAX = Float.parseFloat("0");
		String text = "";

		switch (cat) {

		case GROCERIES:
			text = "ALIMENTACION";
			TAX = Float.parseFloat("0.04");
			break;

		case LUXURY:
			text = "LUJO";
			TAX = Float.parseFloat("0.21");
			break;

		case MATERIALS:
			text = "MATERIALES";
			TAX = Float.parseFloat("0.1");
			break;

		case MECH:
			text = "MECANICA";
			TAX = Float.parseFloat("0.21");
			break;

		default:
			break;
		}

		if (cat != null) {

			System.out.println();
			System.out.println(text);

			if (articles != null && articles.size() > 0) {

				for (Article a : articles) {
					System.out.print(a.getBarCode());
					System.out.print(" - ");
					System.out.print(a.getName().toUpperCase());
					for (int i = 0; i < ((15 - a.getName().length()) + 5); i++) {
						System.out.print(".");
					} // espacio largo + espacio corto
					System.out.print("Total sin IVA: ");
					billed = a.getnSold() * a.getPrice();
					System.out.print(billed.toString().concat("€"));
					System.out.print(" / ");
					System.out.print("Total con IVA: ");
					System.out.print((billed + (billed * TAX)));
					System.out.println("€");

				}
				total += billed;
				System.out.print("TOTAL");
				for (int i = 0; i < (2 + 15 + 5); i++) {
					System.out.print(".");
				} // formato + espacio largo + espacio corto
				System.out.print("Total sin IVA: ");
				System.out.print(total.toString().concat("€"));
				System.out.print(" / ");
				System.out.print("Total con IVA: ");
				System.out.print(total + total * TAX);
				System.out.println("€");

			} else {
				System.out.println("No hay articulos");
			}
		}
	}
}
