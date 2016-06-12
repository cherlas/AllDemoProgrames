package com.huawei.oj1;

import java.util.Scanner;

public class StringSort {
	private static Scanner sc;
	private static String input;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		input=sc.nextLine();
		sort();
	}
private static void sort() {
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<input.length();i++){
		char c=input.charAt(i);
		if(sb.length()==0&&(c>='a'&&c<='z'||c>='A'&&c<='Z')){
			sb.append(c);
			continue;
			
		}else if (c>='a'&&c<='z'||c>='A'&&c<='Z')  {
				char s=sb.charAt(sb.length()-1);
				String ss=(s+"").toLowerCase();
				String cc=(c+"").toLowerCase();
					if (ss.charAt(0)>cc.charAt(0)) {
					int k=sb.length()-1;					
					while(k>=0&&((sb.charAt(k)+"").toLowerCase().charAt(0)>cc.charAt(0))) k--;
					sb.insert(k+1,c);
				}else if(ss.charAt(0)==cc.charAt(0)){
					sb.append(c);
				}else if(ss.charAt(0)<cc.charAt(0)){
					sb.append(c);
				}
			
		}
	}
	for(int i=0;i<input.length();i++){
		char c=input.charAt(i);
		if (!(c>='a'&&c<='z'||c>='A'&&c<='Z')) {
			sb.insert(i, c);
		}
	}
	System.out.println(sb);
  }
}
