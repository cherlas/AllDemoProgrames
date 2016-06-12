package com.huawei.oj3;
import java.util.Scanner;

public class getMaxSameString {
	private static Scanner sc;
	private static String string;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		string=sc.nextLine();
		String[] strings=string.split(" ");
		int k=getCommonStrLength(strings[0].toLowerCase(), strings[1].toLowerCase());
		System.out.println(k);
	}

private static int getCommonStrLength(String first0,String second0) {
		
		String first = first0.toLowerCase();
		String second = second0.toLowerCase();
		
		int fLen = first.length();
		int sLen = second.length();
		int d = (fLen <= sLen) ? fLen : sLen;
		String min = null;
		String max = null;
		String target = null;
		if (fLen <= sLen) {
			min = first;
			max = second;
		} else {
			min = second;
			max = first;
		}
		for (int i = d; i >= 1; i--) {
			for (int j = 0; j <= min.length() - i; j++) {
				target = min.substring(j, j + i);
				for (int k = 0; k <= max.length() - i; k++) {
					if (max.substring(k,k + i).equals(target)) {
						return i;
					}
				}
			}
		}
		return 0;
	}
}
