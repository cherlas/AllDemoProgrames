package com.huawei.oj3;
import java.util.Scanner;

public class FindOneInBinanaryNum {
	
	private static Scanner sc;
	private static int n;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		System.out.println(findNumberOf1(sc.nextInt()));
	}
public static int findNumberOf1(int num){
	int s=0;
	String str=Integer.toBinaryString(num);
	for(int i=0;i<str.length();i++){
		if (str.charAt(i)=='1') {
			s++;
		}
	}
	return s;
	}
}
