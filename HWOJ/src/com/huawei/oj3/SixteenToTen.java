package com.huawei.oj3;
import java.util.Scanner;

public class SixteenToTen {
	private static Scanner sc;
	public static void main(String[] args) {
		
		sc=new Scanner(System.in);
		String str=sc.nextLine();
		String sixteenNumber=str.substring(2, str.length());
		System.out.println(Integer.parseInt(sixteenNumber,16));
	}
}
