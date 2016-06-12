package com.huawei.oj3;
import java.util.Scanner;

public class InvertString {
	
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String string=sc.nextLine();
		for(int i=string.length()-1;i>=0;i--){
			System.out.print(string.charAt(i));
		}
		System.out.println();
	}
}
