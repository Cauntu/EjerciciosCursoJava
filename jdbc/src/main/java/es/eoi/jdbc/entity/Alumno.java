package es.eoi.jdbc.entity;

public class Alumno {

	// FIELDS

	private String dni;
	private String nombre;
	private String apellidos;
	private Integer edad;

	// {GET, SET}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	// CONSTRUCTORS
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	public Alumno(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Alumno(String dni, String nombre, String apellidos, int edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	// METHODS
	
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + "]";
	}

	
}
