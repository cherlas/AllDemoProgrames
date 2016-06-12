package com.huawei.oj1;

import java.util.Scanner;

public class JiFuJunZhengMidiaLevel {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int sum=0,countzs=0,countfs=0;
		 double average=0.0;  
		while(sc.hasNext()) {
		     int temp=sc.nextInt();
		 if(temp>0)  {
		 	 countzs ++; 
		 	 sum+=temp;
		 }
		else if(temp<0) {
		 	  countfs ++; 
		}
		}
		average=(double)sum/countzs;
		System.out.println(countfs);
		System.out.println(Math.round(average*10)/10.0);	
	}
}
