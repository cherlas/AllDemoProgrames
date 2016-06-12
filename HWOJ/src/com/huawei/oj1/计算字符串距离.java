package com.huawei.oj1;

import java.util.Scanner;

public class 计算字符串距离 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		System.out.println(calStringDistance(sc.nextLine(),sc.nextLine()));

	}
private static int calStringDistance(String strA,String strB) {
	if (strA.contains(strB)||strB.contains(strA)) {
		return Math.abs(strA.length()-strB.length());
	}
	String shortStr = strA.length()<strB.length() ? strA:strB;
	String longStr = strA.length()>strB.length() ? strA:strB;
	int count=0;
	for(int i=0;i<shortStr.length();){
		for(int j=shortStr.length()-1;j>=i;j--){
			if (longStr.contains(shortStr.substring(i, j+1))) {
				count+=j-i+1;
				i=j;
				break;
			}			
		}
		i++;
	}
	return longStr.length()-count;
}
}
