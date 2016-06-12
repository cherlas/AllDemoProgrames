package com.huawei.oj1;

import java.util.Scanner;

public class 中级字符串运用密码截取 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String input=sc.nextLine();
		int max=0;
		for(int i=1;i<input.length()-1;i++){
			int l=i-1,r=i+1;
			while(l>=0&&r<input.length()&&input.charAt(l)==input.charAt(r)){
				l--;
				r++;
			}
			if(r-l-1>max){
				max=r-l-1;
			}
		}
		for(int i=1;i<input.length()-1;i++){
			int l=i,r=i+1;
			while(l>=0&&r<input.length()&&input.charAt(l)==input.charAt(r)){
				l--;
				r++;
			}
			if(r-l-1>max){
				max=r-l-1;
			}
		}
		System.out.println(max);
	}
}
