package com.huawei.oj3;
import java.util.Scanner;

public class StringMatch {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		//String[]  inputArr=str.split(" ");
		System.out.println(match(str1,str2));
}
private static String match(String shortString,String longString) {
	int flag=0;
	outer:
	for(int i=0;i<shortString.length();i++){
		for(int j=0;j<longString.length();j++){
			if (shortString.charAt(i)==longString.charAt(j)) {
				flag++;
				continue outer;
			}
		}	
	}	
	if (flag==shortString.length()) {
		return "true";
	}else {
			return "false";
	}
  }
}
