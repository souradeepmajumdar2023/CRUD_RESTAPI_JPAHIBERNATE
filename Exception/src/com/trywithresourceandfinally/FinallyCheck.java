package com.trywithresourceandfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyCheck
{
	public static void main(String[] args)
	{
		 BufferedReader br = null;
	     try
	     {
	        br = new BufferedReader(new FileReader("file.txt"));
	        System.out.println(br.readLine());
	     } 
	     catch (IOException e)
	     {
	        e.printStackTrace();
	     } 
	     finally
	     {
	        try
	        {
	        	if (br != null) br.close(); // manual closing
	        } 	catch (IOException ex)
	        {
	            ex.printStackTrace();
	        }
	     }
	}
}