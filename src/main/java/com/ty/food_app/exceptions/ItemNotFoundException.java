package com.ty.food_app.exceptions;

public class ItemNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Item details are not available";
	}

}
