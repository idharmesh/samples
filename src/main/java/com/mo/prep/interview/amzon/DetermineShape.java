package com.mo.prep.interview.amzon;

/**
 * Addapar
 * 
 * @author
 *
 */
public class DetermineShape {

	public static void main(String[] args) {

		int[][] array = { { 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 1, 1, 0, 0, 0 } };

		System.out.println(findShape(array));

		array = new int[][] { { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0 } };

		System.out.println(findShape(array));

	}

	public static String findShape(int[][] a) {
		int l = a.length;
		int h = a[0].length;

		int x = (h - 1) / 2;
		int y = (l - 1) / 2;

		int radius = y;
		int valueAtCenter = a[y][x];

		while (radius > -1) {
			// - radius --> 1,2,3,4 // Go up on next
			for (int i = x - radius; i <= x; i++) {
				if (a[radius][i] != valueAtCenter) {

					return "Not very circular";
				}
			}
			// + radius ==> 7,6,5,4 // Go down on next
			for (int i = x + radius; i >= x; i--) {
				if (a[radius][i] != valueAtCenter) {
					return "Not very circular";
				}
			}
			// reduce
			radius--;
		}
		return "Pretty cicular";
	}

	// sreenath.are@addepar.com

	private static String evalArray(int[][] array) {

		String eval = "Pretty cicular";
		int[] patternChange = new int[array.length];
		int change = 0;
		int tmp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (j == 0) {
					tmp = array[i][j];
					continue;
				}
				if (array[i][j] != tmp) {
					change++;
					tmp = array[i][j];
				}
			}
			patternChange[i] = change;
			change = 0;
		}
		for (int i = 0; i < patternChange.length; i++) {
			if (patternChange[i] > 3) {
				eval = "Not very circular";
				break;
			}
		}
		return eval;
	}
}
