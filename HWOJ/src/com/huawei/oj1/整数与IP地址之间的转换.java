package com.huawei.oj1;

import java.util.Scanner;

public class 整数与IP地址之间的转换 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String[] ipAdd=sc.next().split("\\.");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<ipAdd.length;i++){
			String str=Integer.toBinaryString(Integer.parseInt(ipAdd[i]));
			while(str.length()<8) str="0"+str;
			sb.append(str);
		}
		System.out.println(Long.parseLong(sb.toString(),2));

		String string=Long.toBinaryString(sc.nextLong());
		while(string.length()%8!=0) string="0"+string;
		sb.delete(0, sb.length());
		for(int i=0;i<4;i++){
			sb.append(Integer.parseInt(string.substring(i*8,i*8+8),2));
			if (i!=3) {
				sb.append(".");
			}
		}
		System.out.println(sb);
	}
}
