package com.ty.food_app.exceptions;

public class UserNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "User details are not available";
	}

}
