package com.huawei.oj1;

import java.util.Scanner;

public class 字符串加密 {
	private static Scanner sc;
	private static String tempString,keyString,encryptString;
	private static String originalString="abcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		keyString=sc.nextLine();
		encryptString=sc.nextLine();
		tempString="";
		for(int i=0;i<keyString.length();i++){
			if (!tempString.contains(keyString.charAt(i)+"")) {
				tempString+=keyString.charAt(i);
			}
		}
		tempString=tempString.toLowerCase();
		for(int i=0;i<26;i++){
			if(!tempString.contains(originalString.charAt(i)+"")){
				tempString+=originalString.charAt(i);
			}
		}
		String resultString="";
		for(int i=0;i<encryptString.length();i++){
			char c=encryptString.charAt(i);
			if (c==' ') {
				resultString+=c;
			}else if (c>='A'&&c<='Z') {
				resultString=resultString+(char)(tempString.charAt(originalString.indexOf((char)(c+32)))-32);
			}else {
				resultString=resultString+(tempString.charAt(originalString.indexOf(c)));
			}
		}
		System.out.println(resultString);
	}
}
