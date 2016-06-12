package com.huawei.oj1;

import java.util.Scanner;

public class SelfShouNumber {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(calcAutomorphicNumbers(N));
	}
private static int calcAutomorphicNumbers(int n) {
	int count=0;
	
	for(int i=0;i<=n;i++){
		String originalString=String.valueOf(i);
		String squareString=String.valueOf((i*i));	
		String sub=squareString.substring(squareString.length()-originalString.length(), squareString.length());
		if (sub.equals(originalString)) {
			count++;
		}
	}
	return count;
}
}
