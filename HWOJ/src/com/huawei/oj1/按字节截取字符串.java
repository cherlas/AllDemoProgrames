package com.huawei.oj1;

import java.util.Scanner;

public class 按字节截取字符串 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String input=sc.next();
		int num=sc.nextInt();
		int k=0;
		String sub = null;
		for(int i=0;i<input.length();i++){
			char c=input.charAt(i);
			int v=(int)c;
			if (v>=19968 && v<=171941) {
				k+=2;
			}else {
				k++;
			}
			if (k==num) {
				sub=input.substring(0,i+1);
				break;
			}else if (k>num&&(v>=19968 && v<=171941)) {
				sub=input.substring(0,i);
			}
		}
		System.out.println(sub);
	}
}
