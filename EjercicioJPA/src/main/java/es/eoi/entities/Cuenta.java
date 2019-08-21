package es.eoi.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cuentas")
public class Cuenta {

	// ATRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private int idCuenta;
	
	@Column
	private int idBanco;
	
	@Column
	private float saldo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni", referencedColumnName = "dni")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBanco", referencedColumnName = "idBanco")
	private Banco banco;
	
	//{GET,SET}
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//CONSTRUCTORS
	
	public Cuenta() {
		super();
	}
	
	public Cuenta(int idCuenta, int idBanco, float saldo) {
		super();
		this.idCuenta = idCuenta;
		this.idBanco = idBanco;
		this.saldo = saldo;
	}

	
	
	
}
