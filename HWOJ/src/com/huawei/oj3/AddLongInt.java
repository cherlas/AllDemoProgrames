package com.huawei.oj3;
import java.math.BigDecimal;
import java.util.Scanner;

public class AddLongInt {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();	
		System.out.println(addLongInteger(str1,str2));
	}
	private static String addLongInteger(String str1,String str2) {
		BigDecimal bd1=new BigDecimal(str1);
		BigDecimal bd2=new BigDecimal(str2);
		BigDecimal sum=bd1.add(bd2);

		return sum.toString();
	}
}
