package com.huawei.oj1;

import java.util.Scanner;

public class SimplePasswordCrack {
	private static Scanner sc;
	private static String[] key=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			System.out.println(crackPassword(sc.nextLine()));
		}

	}
private static String crackPassword(String str) {
	StringBuffer result=new StringBuffer(str);
	for(int i=0;i<str.length();i++){
		if (str.charAt(i)>='A'&&str.charAt(i)<'Z') {
			char c=(char) (str.charAt(i)+33);
			result.replace(i, i+1, c+"");
		}else if (str.charAt(i)=='Z') {
			result.replace(i, i+1, "a");
		}else if (str.charAt(i)>='a'&&str.charAt(i)<='z') {
			for(int j=0;j<8;j++){
				if (key[j].contains(str.charAt(i)+"")) {
					result.replace(i, i+1, j+2+"");
					break;
				}
			}
		}
	}
	return result.toString();
}
}
