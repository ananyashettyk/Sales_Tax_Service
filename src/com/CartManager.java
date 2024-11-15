package com;

import java.util.Scanner;

public class CartManager {

	private final Cart cart;

	public CartManager(Cart cart) {
		this.cart = cart;
	}

	public void collectItems(Scanner scanner) {
		while (true) {
			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("done")) {
				break;
			}

			// Parse and add the item to the cart
			TaxableItem item = TaxableItem.fromInput(input);
			if (item != null) {
				cart.addItem(item);
			}
		}
	}
}
