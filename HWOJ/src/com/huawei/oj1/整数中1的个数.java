package com.huawei.oj1;

import java.util.Scanner;

public class 整数中1的个数 {
	private static Scanner sc;
	private static int count;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str=Integer.toBinaryString(sc.nextInt());
		count=0;
		for(int i=0;i<str.length();i++){
			if (str.charAt(i)=='1') {
				count++;
			}
		}
		System.out.println(count);
	}
}
