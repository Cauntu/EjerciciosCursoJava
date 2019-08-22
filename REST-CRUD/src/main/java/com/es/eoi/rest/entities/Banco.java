package com.es.eoi.rest.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "bancos")
public class Banco {
	
	//ATRIBUTES
	@Id
	@Column(unique = true)
	private int idBanco;
	
	@Column
	private String nombre;
	
	@Column
	private String ciudad;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	
	//{GET,SET}
	
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	// CONSTRUCTORS
	
	public Banco() {
		super();
	}
	public Banco(int idBanco, String nombre, String ciudad) {
		super();
		this.idBanco = idBanco;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}
	
	
	
	
}
