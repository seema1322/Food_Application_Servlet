package com.ty.food_app.exceptions;

public class MenuNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Menu details are not available";
	}

}
