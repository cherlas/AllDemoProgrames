package com.huawei.oj1;

import java.util.Scanner;

public class LongestCommonString {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		int len=0;
		String commonString="";
		for(int i=0;i<str1.length();i++){
			for(int j=i+1;j<=str1.length();j++){
				String sub=str1.substring(i,j);
			
				if (str2.contains(sub)&&sub.length()>len) {
					len=sub.length();
					commonString=sub;
				}
			}
		}
		System.out.println(commonString);
	}
}
