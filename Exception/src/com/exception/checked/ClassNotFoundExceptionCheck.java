package com.exception.checked;

public class ClassNotFoundExceptionCheck {

	public static void main(String[] args) {
		try {
            Class.forName("com.unknown.ClassName"); // Throws ClassNotFoundException
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e);
        }
	}
}
