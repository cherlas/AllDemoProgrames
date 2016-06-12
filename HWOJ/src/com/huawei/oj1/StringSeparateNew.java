package com.huawei.oj1;

import java.util.Scanner;

public class StringSeparateNew {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String string1=sc.nextLine();
		String string2=sc.nextLine();
		while(string1.length()%8!=0)
			string1+="0";
		while(string2.length()%8!=0)
			string2+="0";
		
		print(string1);
		print(string2);
	}

	private static void print(String str) {
		for(int i=0;i<str.length();i++){
			System.out.print(str.charAt(i));
			if (i%8==7&&i!=0) {
				System.out.println();
			}
		}
	}
}
