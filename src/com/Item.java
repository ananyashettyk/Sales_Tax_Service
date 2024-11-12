package com;

public class Item {

	private String name;
	private double price;
	private boolean isImported;
	private String category;

	public Item(String name, double price, boolean isImported, String category) {
		this.name = name;
		this.price = price;
		this.isImported = isImported;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isImported() {
		return isImported;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
