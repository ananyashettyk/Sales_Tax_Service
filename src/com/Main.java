package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Cart cart = new Cart();
		CartManager cartManager = new CartManager(cart);

		// Collect items from the user until 'done' is typed
		cartManager.collectItems(scanner);

		System.out.println();

		Receipt receipt = cart.generateReceipt();
		System.out.println(receipt);

		scanner.close();
	}
}
