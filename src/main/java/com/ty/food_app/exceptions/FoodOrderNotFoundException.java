package com.ty.food_app.exceptions;

public class FoodOrderNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Order details are not available";
	}

}
