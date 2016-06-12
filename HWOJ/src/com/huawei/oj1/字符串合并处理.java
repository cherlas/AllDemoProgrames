package com.huawei.oj1;

import java.util.Scanner;

public class 字符串合并处理 {
	private static Scanner sc;
	public static void main(String[] args) {
	
	sc=new Scanner(System.in);
	StringBuffer sb=new StringBuffer(sc.next());
	sb.append(sc.next());
	
	processString(sb.toString());
	}
private static  void processString(String str) {
	StringBuffer sb=new StringBuffer(str);
	for(int i=0;i<sb.length();i+=2){
		for(int j=i+2;j<sb.length();j+=2){
			if (sb.charAt(j)<sb.charAt(i)) {
				char c=sb.charAt(j);
				sb.replace(j, j+1, sb.charAt(i)+"");
				sb.replace(i, i+1, c+"");
			}
		}		
	}
	for(int i=1;i<sb.length();i+=2){
		for(int j=i+2;j<sb.length();j+=2){
			if (sb.charAt(j)<sb.charAt(i)) {
				char c=sb.charAt(j);
				sb.replace(j, j+1, sb.charAt(i)+"");
				sb.replace(i, i+1, c+"");
				}
			}
		}
	for(int i=0;i<sb.length();i++){
		char c=sb.charAt(i);
		if (c>='0'&&c<='9'||c>='A'&&c<='F'||c>='a'&&c<='f') {
			String string=Integer.toBinaryString(Integer.parseInt(c+"",16));
			String afterString=swap(string);
			char res=Integer.toHexString(Integer.parseInt(afterString,2)).charAt(0);
			if (res>='a'&&res<='f') {
				res-=32;
			}
			sb.replace(i, i+1, (char)res+"");
		}
	}
	System.out.print(sb);// 没有回车
  }

private static String swap(String string) {
	StringBuffer str=new StringBuffer();
	
	for(int i=string.length()-1;i>=0;i-- )
		str.append(string.charAt(i)+"");
	return str.toString();
}
}
