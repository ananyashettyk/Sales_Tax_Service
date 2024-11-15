package com;

public class TaxableItem extends Item {

	private static final double BASIC_SALES_TAX_RATE = 0.10; // 10%
	private static final double IMPORT_DUTY_RATE = 0.05; // 5%

	public TaxableItem(String name, double price, boolean isImported, String category) {
		super(name, price, isImported, category);
	}

	public static TaxableItem fromInput(String input) {
		String[] parts = input.split(" at ");
		if (parts.length != 2) {
			System.out.println("Invalid input format. Please enter in the format '1 xyz at 00.00'.");
			return null;
		}

		try {
			String name = parts[0].trim();
			double price = Double.parseDouble(parts[1].trim());
			boolean isImported = name.toLowerCase().contains("imported");
			String category = determineCategory(name);

			return new TaxableItem(name, price, isImported, category);
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format. Please enter a valid price.");
			return null;
		}
	}

	private static String determineCategory(String name) {
		if (name.toLowerCase().contains("book")) {
			return "BOOKS";
		} else if (name.toLowerCase().contains("chocolate")) {
			return "FOODS";
		} else if (name.toLowerCase().contains("pills")) {
			return "MEDICAL_PRODUCTS";
		} else {
			return "OTHER";
		}
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
