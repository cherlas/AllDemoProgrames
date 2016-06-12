package com.huawei.oj1;

import java.math.BigDecimal;
import java.util.Scanner;

public class HighPrecisionAdd {
	
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		System.out.println(add(str1,str2));

	}
public static String add(String num1,String num2) {
	
	BigDecimal bd1=new BigDecimal(num1);
	BigDecimal result=bd1.add(new BigDecimal(num2));
	result.stripTrailingZeros();
	return result.toString();
}
}
