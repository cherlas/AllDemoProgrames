package com.huawei.oj1;

import java.util.Scanner;

public class StringSeparate {
	private static Scanner sc;
	private static String[] strings;
	private static int flag=0;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		
		String[] inputString=new String[2];
		inputString[0]=sc.nextLine();
		inputString[1]=sc.nextLine();
		strings=new String[inputString[1].length()/8+2+inputString[0].length()];
		if (inputString[0].length()==0) {
			System.out.println();
		}else {
			separate(inputString[0]);
		}
		if (inputString[1].length()==0) {
			System.out.println();
		}else {
			separate(inputString[1]);
		}
		
		for(int i=0;i<flag;i++){
			System.out.println(strings[i]);
		}
	}
private static void separate(String str) {
	if (str.length()<8) {
		int k=str.length();
		for(int i=0;i<8-k;i++){
			str=str+"0";
		}
		strings[flag]=str;
		flag++;
	}else if (str.length()==8) {
		strings[flag]=str;
		flag++;
	}else {
		int k=str.length()/8;
		for(int i=0;i<k;i++){
			strings[flag]=str.substring(i*8,i*8+8);
			flag++;
		}
		int s=str.length()%8;
		if(s!=0){
			String sub=str.substring(8*k,str.length());
			for(int i=0;i<8-s;i++){
				sub=sub+"0";
			}
			strings[flag]=sub;
			flag++;
		}
	}
}
}
