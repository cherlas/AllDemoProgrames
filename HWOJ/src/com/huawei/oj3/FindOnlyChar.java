package com.huawei.oj3;
import java.util.Scanner;

public class FindOnlyChar {
	
	private static Scanner sc;
	private static String inputString;
	private static StringBuffer sb=new StringBuffer();
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputString=sc.nextLine();
		sb.append(inputString);
		findChar();
	}
	
	private static void findChar() {
		int flag=0;
		for(int i=0;i<inputString.length();i++){
			StringBuffer sb1=new StringBuffer();
			sb1.append(inputString);
			String str=sb1.substring(i,i+1);
			sb1.delete(i, i+1);
			if(sb1.toString().contains(str)){
				flag++;
				continue;
			}else if(str.equals(" ")){
				System.out.println('.');
				break;
			}else{
				System.out.println(str);
				break;
			}
		}
		if (flag==inputString.length()) {
			System.out.println('.');
		}
	}
}
