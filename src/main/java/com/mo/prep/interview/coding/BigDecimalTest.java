package com.mo.prep.interview.coding;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalTest {
	public static String formatRupees(double value) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(5);
		return format.format(value);
	}

	public static void main(String[] args) {
		BigDecimal tempBig = new BigDecimal(22.12);
		System.out.println("tempBig = " + formatRupees(tempBig.doubleValue()));

		System.out.println("\n\n ===================== \n");
		int scale = 4;
		double value = 0.11111;
		System.out.println("Doble value = " +  value);
		tempBig = new BigDecimal(Double.toString(value));
		tempBig = tempBig.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
		String strValue = tempBig.stripTrailingZeros().toPlainString();
		System.out.println("tempBig = " + strValue);
		
		System.out.println(5/2);
	}

}
