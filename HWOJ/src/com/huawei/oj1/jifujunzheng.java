package com.huawei.oj1;

import java.util.Scanner;

public class jifujunzheng {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sumOfPositive=0,countOfNegative = 0;
		for(int i=0;i<num;i++){
			int k=sc.nextInt();
			if (k<0) {
				countOfNegative++;
			}else {
				sumOfPositive+=k;
			}
		}
	String sum=String.valueOf(((double)sumOfPositive/(num-countOfNegative)));
	String[] sub=sum.split("\\.");
	if (Integer.parseInt(sub[1])==0) {
		System.out.println(countOfNegative+" "+sub[0]);
	}else {
		System.out.println(countOfNegative+" "+sum.substring(0, sum.indexOf(".")+2));
	}
	}
}
