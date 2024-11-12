package com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

	private List<TaxableItem> items = new ArrayList<>();

	public void setItem(TaxableItem item) {
		items.add(item);
	}

	public List<TaxableItem> getItems() {
		return items;
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

	public Receipt generateReceipt(List<TaxableItem> items) {

		double totalTax = getTotalSalesTax();

		List<String> itemDetails = items.stream().map(item -> item.toString()).collect(Collectors.toList());

		double totalCost = getTotalPrice();

		return new Receipt(itemDetails, totalTax, totalCost);
	}
}
