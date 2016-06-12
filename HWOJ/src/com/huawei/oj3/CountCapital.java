package com.huawei.oj3;
import java.util.Scanner;

public class CountCapital {
	
	private static Scanner sc;
	public static void main(String[] args) {
		
		sc=new Scanner(System.in);
		String string=sc.nextLine();
		if (string.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(calcCapital(string));
		}

	}
private static int calcCapital(String str) {
	int count=0;
	for(int i=0;i<str.length();i++){
		if (str.charAt(i)>='A'&& str.charAt(i)<='Z') {
			count++;
		}
	}
	return count;
	}
}
