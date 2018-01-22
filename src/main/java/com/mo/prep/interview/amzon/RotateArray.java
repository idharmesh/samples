package com.mo.prep.interview.amzon;
import java.util.*;
public class RotateArray {

	
	    
	    public static int[] rotateArray(int[] arr, int d){
	        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
	        int n = arr.length;
	        
	        System.out.println("1:"+Arrays.toString(arr));
	        
	        // Create a temporary d-element array to store elements shifted to the left of index 0:
	        int[] temp_arr = Arrays.copyOfRange(arr, 0, d);
	       
	        
	        System.out.println("2:"+Arrays.toString(temp_arr));
	        // Shift elements from indices d through n to indices 0 through d - 1:
	        for(int i = d; i < n; i++) {
	            arr[i - d] = arr[i];
	        }
	        
	        System.out.println("3:"+Arrays.toString(arr));
	        
	        // Copy the d shifted elements from the temporary array back to the original array:
	        for(int i = n - d; i < n; i++) {
	            arr[i] = temp_arr[i-n+d];
	        }
	        System.out.println("4:"+Arrays.toString(arr));
	        return arr;
	    }
	    
	    public static void main(String[] args) {
	        
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int d = scanner.nextInt();
	        int[] numbers = new int[n];
	        
	        // Fill initial array:
	        for(int i = 0; i < n; i++){
	            numbers[i] = scanner.nextInt();
	        }
	        
	        // Rotate array by d elements:
	        numbers = rotateArray(numbers, d);
	        
	        // Print array's elements as a single line of space-separated values:
	        for(int i : numbers) {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	        
	        scanner.close();
	    } 
	        
	}
/*
	import java.util.*;
	import java.lang.System;

	public class Solution {
	    
	    public static int[] rotateArray(int[] arr, int d){
	        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
	        int n = arr.length;
	        
	        // Create new array for rotated elements:
	        int[] rotated = new int[n]; 
	        
	        // Copy segments of shifted elements to rotated array:
	        System.arraycopy(arr, d, rotated, 0, n - d);
	        System.arraycopy(arr, 0, rotated, n - d, d);

	        return rotated;
	    }
	    
	    public static void main(String[] args) {
	        
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int d = scanner.nextInt();
	        int[] numbers = new int[n];
	        
	        // Fill initial array:
	        for(int i = 0; i < n; i++){
	            numbers[i] = scanner.nextInt();
	        }
	        
	        // Rotate array by d elements:
	        numbers = rotateArray(numbers, d);
	        
	        // Print array's elements as a single line of space-separated values:
	        for(int i : numbers) {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	        
	        scanner.close();
	    } 
	        
	}
*/