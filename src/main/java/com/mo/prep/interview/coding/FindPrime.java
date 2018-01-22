package com.mo.prep.interview.coding;

public class FindPrime {

	public static void main(String[] args) {
		System.out.println(" === Prime ===");
		System.out.println("2%2 = " + 2%2);
		findPrime(20);
		
		System.out.println(" === Fibbonacci ===");
		for(int i =1; i<= 12; i++){
			System.out.print(fibbonacci(i) + " ");
		}
		System.out.println("=== If binary == ");
		System.out.println("101 is binay : " + isBinary(101));
		System.out.println("112 is binay : " + isBinary(112));
	}
	
	private static boolean isBinary(int i) {
		int copy = i;
		while(copy != 0) {
			if(copy %10 > 1){
				return false;
			}
			copy = copy/10;
		}
		return true;
	}

	public static void findPrime(int number) {
		
		if(number < 2 ){
			System.out.println("Invalid input..");
			return;
		}
		System.out.println("Prime Number..");
		for(int i=2; i<= number ; i++) {
			
			if(isPrime(i)){
				System.out.println(i);
			}
		}
	}
	private static boolean isPrime(int num) {
		for(int i=2; i< num; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}
	
	public static int fibbonacci(int num){
		if(num > 0 && num <= 2 )
			return 1;
		return fibbonacci(num -1) + fibbonacci(num -2);
	}
}
