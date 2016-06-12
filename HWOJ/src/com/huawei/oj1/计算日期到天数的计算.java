package com.huawei.oj1;

import java.util.Scanner;

public class 计算日期到天数的计算 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int year=sc.nextInt();
		int mounth=sc.nextInt();
		int day=sc.nextInt();
		int count=0;
		int[] dayOfMounth={0,31,28,31,30,31,30,31,31,30,31,30,31};
		if (mounth>12||day>dayOfMounth[mounth]) {
			System.out.println("Error");
		}else {			
			for(int i=0;i<mounth;i++){
				count+=dayOfMounth[i];
			}
			count+=day;
			if (year%100==0) {
				if (year%400==0) {
					count++;
				}
			}else if(year%4==0){
				count++;
			}
		}
		System.out.println(count);
	}
}
