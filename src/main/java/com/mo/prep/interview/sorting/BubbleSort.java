package com.mo.prep.interview.sorting;

public class BubbleSort {
	int arr[] = new int[50];
	int arraySize = 10;
	public void fillArray(){
		arr[0] = 24;
		arr[1] = 12;
		arr[2] = 19;
		arr[3] = 18;
		arr[4] = 16;
		arr[5] = 21;
		arr[6] = 10;
		arr[7] = 8;
		arr[8] = 28;
		arr[9] = 14;
		
	}
	public void printArray (){
		System.out.println("----------");
		for (int i = 0; i < arraySize; i++) {
			System.out.println("| " +i+" | " + arr[i] + " |");
		}
		System.out.println("----------");
	}
	
	public void binarySearch(int value) {
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		while(lowIndex <= highIndex){
			int middleIndex = (lowIndex + highIndex )/2;
			if(arr[middleIndex] < value) {
				lowIndex = middleIndex +1;
			}
			else if (arr[middleIndex] > value) {
				highIndex = middleIndex -1;
			}
			else{
				System.out.println("Found value at {"+middleIndex+"} ");
				lowIndex = highIndex +1;
			}
		}
	}
	
	public void bubble(){
		for (int i = arraySize-1; i > 2; i--) {
			for (int j = 0; j < arraySize-1; j++) {
				if(arr[j] >  arr[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	public void selectionSort() {
		for (int x = 0; x < arraySize; x++) {
			int min = x;
			for (int y = x+1; y < arraySize; y++) {
				if(arr[y] < arr[min]) {
					min = y;
				}
			}
			swap(x,min);
		}
	}
	
	public void insertionSort() {
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			int valueToInsert = arr[i];
			while((j >0 ) && (arr[j-1] > valueToInsert)){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = valueToInsert; 
		}
	}
	
	private void swap(int j, int i) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		b.fillArray();
		b.printArray();
		//b.bubble();
		//b.selectionSort();
		b.insertionSort();
		b.printArray();
		//b.binarySearch(12);
		
		
	}
	
	

}
