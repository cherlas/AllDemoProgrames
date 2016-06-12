package com.huawei.oj2;
//ip转整数
import java.util.Scanner;
import java.util.StringTokenizer;

public class  IP转整数_StringTokenizer{
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		toLong(sc.nextLine());

	}

	private static void toLong(String ipstr) {
		long result = 0;
		StringTokenizer token = new StringTokenizer(ipstr, ".");
		//System.out.println(token.nextToken());
		result =Long.valueOf(token.nextToken())<<24;
		System.out.println(result);
		result =Long.valueOf(token.nextToken())<<16;
		System.out.println(result);
		result =Long.valueOf(token.nextToken())<<8;
		System.out.println(result);
		result =Long.valueOf(token.nextToken());
		System.out.println(result);
		
		System.out.println((long)(192*Math.pow(2, 24)));
	}
}
