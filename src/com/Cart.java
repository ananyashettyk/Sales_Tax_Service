package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

	private List<TaxableItem> items = new ArrayList<>();

	public void addItem(TaxableItem item) {
		items.add(item);
	}

	public double getTotalSalesTax() {
		double totalSalesTax = 0;
		for (TaxableItem item : items) {
			totalSalesTax += item.calculateSalesTax();
		}
		return totalSalesTax;
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (TaxableItem item : items) {
			totalPrice += item.calculatePriceIncludingTax();
		}
		return totalPrice;
	}

	public Receipt generateReceipt() {
		List<String> itemDetails = items.stream().map(item -> item.toString()).collect(Collectors.toList());
		double totalTax = getTotalSalesTax();
		double totalCost = getTotalPrice();

		return new Receipt(itemDetails, totalTax, totalCost);
	}
}
