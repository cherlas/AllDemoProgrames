package com.huawei.oj1;

import java.util.Scanner;

public class SmallestGongBeiNum {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int common=0;
		int C=A<B ? A:B;
		for(int i=C;i>=1;i--)
			if (A%i==0&&B%i==0) {
				common=i;
				break;
			}
		System.out.println(A*B/common);
	}
}
