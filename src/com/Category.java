package com;

public enum Category {
	BOOKS, FOODS, MEDICAL_PRODUCTS;

	public static boolean isValidCategory(String category) {
		for (Category c : Category.values()) {
			if (c.name().equalsIgnoreCase(category)) {
				return true;
			}
		}
		return false;
	}
}