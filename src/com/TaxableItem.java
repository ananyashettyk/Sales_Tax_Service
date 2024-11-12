package com;

public class TaxableItem extends Item {

	private static final double BASIC_SALES_TAX_RATE = 0.10; // 10%
	private static final double IMPORT_DUTY_RATE = 0.05; // 5%

	public TaxableItem(String name, double price, boolean isImported, String category) {
		super(name, price, isImported, category);
	}

	public double calculateSalesTax() {
		double salesTax = 0.0;

		if (!Category.isValidCategory(getCategory())) {
			salesTax = getPrice() * BASIC_SALES_TAX_RATE;
		}

		if (isImported()) {
			salesTax += getPrice() * IMPORT_DUTY_RATE;
		}

		return round(salesTax);
	}

	private double round(double val) {
		return Math.ceil(val * 20) / 20.0;
	}

	public double calculatePriceIncludingTax() {
		return getPrice() + calculateSalesTax();
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f", getName(), calculatePriceIncludingTax());
	}
}
