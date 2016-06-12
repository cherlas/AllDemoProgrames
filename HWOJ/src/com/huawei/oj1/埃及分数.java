package com.huawei.oj1;

import java.util.Scanner;
class 埃及分数 {
	private static String[] inputData;
	private static int a,b;
	private static String in;
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		in=sc.next();
		if (in.length()==1&&Integer.parseInt(in)==1) {
			System.out.println(1+"/1");
		}else if (in.length()==1) {
			System.out.println("Error");
		}else {
			inputData=in.split("\\/");
		a=Integer.parseInt(inputData[0]);
		b=Integer.parseInt(inputData[1]);
		int c;
		String result="";
		while(true){
			if (b%a!=0) {
				c=b/a+1;
			}else {
				c=b/a;
				a=1;
			}
			
			if (a==1) {
				result=result+"1/"+c;
				break;
			}else {
				result=result+"1/"+c+"+";
			}
			a=a*c-b;
			b=b*c;
			}
		System.out.println(result);
		}
		
	}
}
