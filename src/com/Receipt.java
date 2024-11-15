package com;

import java.util.List;

public class Receipt {

	private List<String> items;
	private double totalTax;
	private double total;

	public Receipt(List<String> items, double totalTax, double total) {
		this.items = items;
		this.totalTax = totalTax;
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder receiptDetails = new StringBuilder();

		for (String item : items) {
			receiptDetails.append(item).append("\n");
		}

		receiptDetails.append("Sales Taxes: ").append(String.format("%.2f", totalTax)).append("\n");
		receiptDetails.append("Total: ").append(String.format("%.2f", total));

		return receiptDetails.toString();
	}
}
