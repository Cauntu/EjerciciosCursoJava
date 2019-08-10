package com.es.eoi.myWeirdoShop.entities;

public class Article {

	// ENUMS

	public enum Tax {
		REDUCED, SPECIAL, NORMAL;
	}

	public enum Category {
		GROCERIES, MATERIALS, MECH, LUXURY;
	}

	// FIELDS

	private String barCode;
	private String name;
	private String description;
	private Tax IVA;
	private float price;
	private int stock;
	private int nSold;
	private Category cat;

	// {GET, SET}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tax getIVA() {
		return IVA;
	}

	public void setIVA(Tax iVA) {
		IVA = iVA;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getnAvailable() {
		return stock;
	}

	public void setnAvailable(int nAvailable) {
		this.stock = nAvailable;
	}

	public int getnSold() {
		return nSold;
	}

	public void setnSold(int nSold) {
		this.nSold = nSold;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	// CONSTRUCTORS

	public Article(String name, String description, float price, Category cat, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.cat = cat;
		this.stock = stock;
		this.nSold = 0;

		switch (cat) {

		case GROCERIES:
			this.IVA = Tax.REDUCED;
			break;
			
		case MECH:
			this.IVA = Tax.NORMAL;
			break;
			
		case MATERIALS:
			this.IVA = Tax.SPECIAL;
			break;
			
		case LUXURY:
			this.IVA = Tax.NORMAL;
			break;
			
		default:
			this.IVA = Tax.NORMAL;
			break;
		}

	}

}
