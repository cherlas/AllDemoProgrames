package com.huawei.oj1;

import java.util.Scanner;

public class WildCardOfString {
	private static Scanner sc;
	private static String string1,string2;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		string1=sc.nextLine();
		string2=sc.nextLine();
		System.out.println(findString());
	}

	private static String findString() {
		
		if(!(string1.contains("?")||string1.contains("*")))
			if (string2.contains(string1)) {
				return "true";
			}else {
				return "false";
			}
		for(int i=0;i<string2.length();i++){
			int k=i;
			int j=0;
			while(j<string1.length()){
				if (string1.charAt(j)=='?') {
					k++;
					j++;
					if (j==string1.length()) {
						return "true";
					}
					continue;
				}else if (string1.charAt(j)=='*') {
					if (j==string1.length()-1) {
						return "true";
					}
					j++;
					k++;
					while(k<string2.length()&&j<string1.length()&&string2.charAt(k)!=string1.charAt(j)){
						if (j==string1.length()-1) {
							return "true";
						}else {
							
							k++;
						}
					}
				}else {
					while(string2.charAt(k)==string1.charAt(j)&&k<string2.length()&&j<string1.length()){
						k++;
						j++;
						if (j==string1.length()) {
							return "true";
						}
					}
				}
				if (j==string1.length()) {
					return "true";
				}else if (string1.charAt(j)!=string2.charAt(k)&&string1.charAt(j)!='*'&&string1.charAt(j)!='?') {
					break;
				}
			}
		}
		return "false";
	}
}
