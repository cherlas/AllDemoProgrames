package com.huawei.oj1;

import java.util.Scanner;

public class NumOfOne {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int input=sc.nextInt();
		int count=0;
		String str=Integer.toBinaryString(input);
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='1'){
				count++;
			}
		}
		System.out.println(count);
	}
}
