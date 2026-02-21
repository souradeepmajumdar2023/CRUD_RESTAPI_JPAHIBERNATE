package com.exception.checked;

import java.io.FileReader;
import java.io.IOException;

public class IOExceptionCheck {

	public static void main(String[] args) {
		try {
            FileReader fr = new FileReader("file.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e);
        }
	}

}
