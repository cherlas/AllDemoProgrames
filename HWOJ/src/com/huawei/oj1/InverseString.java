package com.huawei.oj1;

import java.util.Scanner;

public class InverseString {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String input=sc.nextLine();
		char[] charArr=input.toCharArray();
		for(int i=charArr.length-1;i>=0;i--){
			System.out.print(charArr[i]);
		}
			System.out.println();
	}
}
