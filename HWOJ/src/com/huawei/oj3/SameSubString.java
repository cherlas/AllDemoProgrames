package com.huawei.oj3;
import java.util.Scanner;

public class SameSubString {
	private static Scanner sc;
	private static String string;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		string=sc.nextLine();
		String[] strings=string.split(" ",2);
		int k=getCommonStrLength(strings[0].toLowerCase(), strings[1].toLowerCase());
		System.out.println(k);
	}

	private static int  getCommonStrLength(String str1,String str2) {
		if (str1.contains(str2)) {
			return str2.length();
		}else if (str2.contains(str1)) {
			return str1.length();
		}else {
			int len=0;
			String shortString=null,longString=null;
			if (str1.length()>str2.length()) {
				len=str2.length();
				shortString=str2;
				longString =str1;
			}else {
				len=str1.length();
				shortString=str1;
				longString =str2;
			}
			for(int d=len-1;d>=1;d--){	
				for(int i=0;i<=len-d;i++){
					String sub=shortString.substring(i, i+d);
					if(longString.contains(sub)){					
							return d;
					}
				}	
			}
		}
	return 0;	
	}
}
