package com;

import java.util.List;

public class Receipt {

	private List<String> items;
	private double totalTax;
	private double total;

	public Receipt() {
	}

	public Receipt(List<String> items, double totalTax, double total) {
		this.items = items;
		this.totalTax = totalTax;
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
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
