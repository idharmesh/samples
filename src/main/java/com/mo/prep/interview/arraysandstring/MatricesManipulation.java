package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;

/*
 *  rotate()
 * 	Given an image represented by an NxN matrix, where each pixel in the image is
	4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	place?
 * 
 *  fillZero() 
 * 	Write an algorithm such that if an element in an MxN matrix is 0, its entire row
	and column are set to 0.

 */
public class MatricesManipulation {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("\n===========	Rotate Matrix 	=======\n");
		
		print2DArray(arr);
		rotate(arr);
		print2DArray(arr);
		
		System.out.println("\n===========	Fill 0 if one element is 0 in Matrix 	=======\n");
		arr = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
		print2DArray(arr);
		fillZero(arr);
		print2DArray(arr);
		arr = new int[][]{{1,2},{3,4}};
		int[][] result = rotate90(arr);
		System.out.println("\n ============================== \n");
		print2DArray(result);
		
	}

	private static int[][] rotate90(int[][] arr ){
		int[][] result = new int[arr.length][arr.length];
		for (int i = 0; i <= arr.length-1; i++) {
			for (int j = 1; j < arr.length-1; j++) {
				result[i][j] = arr[i][j-1];
				result[i][j-1] = arr[j][i];
			}
		}
		print2DArray(result);
		return result;
	}
	private static void rotate(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if(i != j) {
					int tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
			}
		}
	}
	
	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
		and column are set to 0.
	 */
	private static void fillZero(int[][] arr) {
		int i =0, j = 0;
		
		for (i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (j = i; j < arr.length; j++) {
				if(arr[i][j] == 0) {
					flag = true;
					break;
				}
			}
			if(flag) {
				for(int k =0; k<arr.length ;k++) {
					arr[i][k] = 0;
					arr[k][j] = 0;
				}
			}
		}
	}
	
	private static void print2DArray(int[][] arr) {
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.toString(arr[2]));
		System.out.println("\n==================\n");
	}
	
}
