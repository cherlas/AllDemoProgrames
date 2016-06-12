package com.huawei.oj3;
import java.util.Scanner;

public class NumOfChar {
	
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String string=sc.nextLine();
		string=string.toLowerCase();
		int count=0;
		char c=sc.nextLine().toLowerCase().charAt(0);
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)==c){
				count++;
			}
		}
		System.out.println(count);
	}
}
