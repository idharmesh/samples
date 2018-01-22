package com.mo.prep.interview.coding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		
		int sum = sumNumberFromFile();
		System.out.printf("The sum is = %d", sum);
		
	}

	private static int sumNumberFromFile() {
		int sum = 0;
		BufferedReader reader = null;
		try {
			
			reader = new BufferedReader(new FileReader("C:\\0-Interview_Preparation\\interview_prep\\src\\main\\resources\\filewithnumber.txt"));
			String s;
			while((s = reader.readLine() )!= null) {
				sum += Integer.parseInt(s);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
	
}
