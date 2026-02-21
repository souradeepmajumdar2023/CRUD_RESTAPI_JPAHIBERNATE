package com.error;

public class StackOverflowErrorCheck {

	 public static void recursive() {
	        recursive(); // Infinite recursion
	    }

	public static void main(String[] args) {
		recursive();
	}

}
