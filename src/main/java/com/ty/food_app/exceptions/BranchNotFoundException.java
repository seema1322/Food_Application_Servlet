package com.ty.food_app.exceptions;

public class BranchNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Branch details are not available";
	}

}
