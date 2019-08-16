package es.eoi.jdbc.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.eoi.jdbc.entity.Alumno;
import es.jdbc.service.AlumnoService;
import es.jdbc.service.AlumnoServiceImpl;

public class GestionInstituto {

	static AlumnoService myAlumnoService;
	static List<Alumno> alumnos;

	public static void main(String[] args) {

		myAlumnoService = new AlumnoServiceImpl();
		alumnos = new ArrayList<Alumno>();

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
			System.out.println("GESTION INSTITUTO V1");
		} else {
			System.out.println("Hubo un error con su seleccion...");
		}

		System.out.println("-------------------------------");

		System.out.println("1 - Listado Alumnos");
		System.out.println("2 - Busca Alumno (DNI)");
		System.out.println("3 - Crear Alumno");
		System.out.println("4 - Modificar Alumno");
		System.out.println("5 - Eliminar Alumno");
		System.out.println("0 - SALIR");

		System.out.println("-------------------------------");

		try {
			userInput = Integer.parseInt(br.readLine());

		} catch (NumberFormatException e) {
			mainMenu(true);
		}

		switch (userInput) {
		case 0:
			System.exit(0);
			break;

		case 1:
			listAlumnoMenu(false);
			break;

		case 2:
			searchAlumnoMenu(false);
			break;

		case 3:
			newAlumnoMenu(false);
			break;

		case 4:
			editAlumnoMenu(false);

			break;

		case 5:
			deleteAlumnoMenu(false);
			break;

		default:
			mainMenu(true);
			break;

		}

	}

	public static void newAlumnoMenu(boolean retry) throws IOException {

		String naDNI = null;
		String naNombre = null;
		String naApellido = null;
		Integer naEdad = 0;

		System.out.println();

		if (retry) {
			System.out.println("Hubo un error");
		}

		if ((naDNI = preguntaDNI()) != null) {

			if ((naNombre = preguntaNombre()) != null) {

				if ((naApellido = preguntaApellido()) != null) {

					if ((naEdad = preguntaEdad()) != null) {

						if (myAlumnoService.create(new Alumno(naDNI, naNombre, naApellido, naEdad))) {
							System.out.println();
							System.out.println("Alumno añadido con éxito.");
							System.out.println();

							mainMenu(false);

						} else {
							newAlumnoMenu(true);
						}

					}

				}
			}

		} else {
			newAlumnoMenu(true);
		}
		newAlumnoMenu(true);

	}

	public static void listAlumnoMenu(boolean retry) throws IOException {

		alumnos = new ArrayList<Alumno>();

		System.out.println("Listando alumnos...");
		System.out.println();
		alumnos = myAlumnoService.findAll();

		if (alumnos.size() >= 1) {

			for (Alumno a : alumnos) {
				System.out.println("-----");
				System.out.println(a.toString());
				System.out.println();

			}

			mainMenu(false);

		} else {
			System.out.println("No hay alumnos.");
			mainMenu(false);
		}

	}

	public static void searchAlumnoMenu(boolean retry) throws IOException {

		alumnos = new ArrayList<Alumno>();
		alumnos = myAlumnoService.findAll();
		String dni;

		if ((dni = preguntaDNI()) != null) {

			if (alumnos != null) {

				for (Alumno a : alumnos) {

					if (dni.equals(a.getDni())) {
						System.out.println(a.toString());
						mainMenu(false);
					}

				}
				System.out.println("No se ha encontrado ningun alumno con ese DNI.");
				mainMenu(false);

			} else {
				System.out.println("No hay alumnos.");
				mainMenu(false);
			}

		} else {
			searchAlumnoMenu(true);
		}

	}

	public static void editAlumnoMenu(boolean retry) throws IOException {

		alumnos = new ArrayList<Alumno>();
		alumnos = myAlumnoService.findAll();

		String naDNI = null;
		String naNombre = null;
		String naApellido = null;
		//Integer naEdad = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		if (retry) {
			System.out.println("Hubo un error");
		}

		if ((naDNI = preguntaDNI()) != null) {

			if (alumnos != null) {

				for (Alumno a : alumnos) {

					if (naDNI.equals(a.getDni())) {

						System.out.println("Campos: Nombre(N), Apellidos(A)");
						System.out.println("Introduzca el campo que desea editar");
						userInput = br.readLine();

						switch (userInput.toUpperCase()) {
						case "N":
							if ((naNombre = preguntaNombre()) != null) {

								if (myAlumnoService.update(a.getDni(), naNombre, a.getApellidos() ) ) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						case "A":
							if ((naApellido = preguntaApellido()) != null) {

								if (myAlumnoService.update(a.getDni(), a.getNombre(), naApellido ) ) {
									System.out.println("Exito");
									mainMenu(false);
								}
							}
							break;

						default:
							editAlumnoMenu(true);
							break;
						}

					}
				}
			} else {
				System.out.println("No hay alumnos.");
				mainMenu(false);
			}

		} else {
			editAlumnoMenu(true);
		}

	}

	public static void deleteAlumnoMenu(boolean retry) throws IOException {

		alumnos = new ArrayList<Alumno>();
		alumnos = myAlumnoService.findAll();

		String dni;

		if ((dni = preguntaDNI()) != null) {

			for (Alumno a : alumnos) {
				if (dni.equals(a.getDni())) {

					if (myAlumnoService.delete(dni)) {
						System.out.println("Alumno borrado con exito");
						mainMenu(false);

					} else {
						System.out.println("Error al borrar");
					}

				}

			}
			System.out.println("No se ha encontrado ningun alumno con ese DNI");
			deleteAlumnoMenu(true);

		} else {
			deleteAlumnoMenu(true);
		}
	}

	public static String preguntaDNI() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca su DNI (9 digitos)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() == 9) {
			return userInput;

		} else {
			return null;
		}

	}

	public static String preguntaNombre() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca el nombre (max 15 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 15) {
			return userInput;

		} else {
			return null;
		}
	}

	public static String preguntaApellido() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca el apellido (max 25 caracteres)");
		userInput = br.readLine();

		if (userInput != null && userInput.length() <= 30) {
			return userInput;

		} else {
			return null;
		}
	}

	public static Integer preguntaEdad() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.print("Introduzca la edad: ");
		userInput = br.readLine();

		if (userInput != null && Integer.parseInt(userInput) >= 0) {
			return Integer.parseInt(userInput);

		} else {
			return null;
		}
	}

}
