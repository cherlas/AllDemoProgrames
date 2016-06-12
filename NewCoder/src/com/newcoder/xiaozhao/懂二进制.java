package com.newcoder.xiaozhao;

import java.util.Scanner;

public class 懂二进制 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println(countBitDiff(m, n));

	}
	 private static int countBitDiff(int m, int n) {
			String str1=Integer.toBinaryString(m);
			String str2=Integer.toBinaryString(n);
			if (str1.length()<str2.length()) 
				while(str1.length()!=str2.length()) str1="0"+str1;
			else if (str1.length()>str2.length()) 
				while(str1.length()!=str2.length()) str2="0"+str2;
			int count=0;
			for(int i=0;i<str1.length();i++)
				if(str1.charAt(i)!=str2.charAt(i)) count++;
			return count;
	    }
}
