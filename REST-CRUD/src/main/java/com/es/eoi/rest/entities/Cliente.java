package com.es.eoi.rest.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "clientes")
public class Cliente {

	// ATRIBUTES
	@Id
	@Column(unique = true)
	private int dni;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Cuenta> cuentas;
	
	// {GET,SET}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// CONSTRUCTORS

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int dni, String nombre, String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
	}

}
