package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Cart cart = new Cart();

		// Loop to collect items from the user
		while (true) {

			System.out.println("Enter the items (e.g., '1 book at 12.49') or type 'done' to finish:");
			String input = scanner.nextLine().trim();

			// Stop input when user types 'done'
			if (input.equalsIgnoreCase("done")) {
				break;
			}

			String[] parts = input.split(" at ");
			if (parts.length != 2) {
				System.out.println("Invalid input format. Please enter in the format '1 xyz at 00.00'.");
				continue;
			}

			try {
				String name = parts[0].trim();
				double price = Double.parseDouble(parts[1].trim());

				System.out.print("Enter category for " + name + " (BOOKS, FOODS, MEDICAL_PRODUCTS, OTHER): ");
				String category = scanner.nextLine().trim();

				if (!Category.isValidCategory(category) && !category.equalsIgnoreCase("OTHER")) {
					System.out.println("Invalid category. Please enter one of the valid categories.");
					continue;
				}

				boolean isImported = name.toLowerCase().contains("imported");

				TaxableItem item = new TaxableItem(name, price, isImported, category);
				cart.setItem(item);

				System.out.println();
			} catch (NumberFormatException e) {
				System.out.println("Invalid number format. Please enter valid numbers for price.");
			}
		}

		Receipt receipt = cart.generateReceipt(cart.getItems());

		System.out.println();
		System.out.println(receipt);
		scanner.close();
	}
}
