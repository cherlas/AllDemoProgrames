package com.huawei.oj1;

import java.util.Scanner;

public class ExpressNumber {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		StringBuffer sb=new StringBuffer(sc.nextLine());
		for(int i=0;i<sb.length();){
			
			if (i<sb.length()&&sb.charAt(i)>='0'&&sb.charAt(i)<='9') {
				sb.insert(i, "*");
			}else {
				i++;
				continue;
			}
			i++;
			while(i<sb.length()&&sb.charAt(i)>='0'&&sb.charAt(i)<='9') i++;
			sb.insert(i, "*");
		}
		System.out.println(sb);
	}
}
