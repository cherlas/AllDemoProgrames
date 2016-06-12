package com.huawei.oj1;

import java.util.Scanner;

public class 四舍五入相似数 {
	private static Scanner sc;
	private static float floatNum;
	private static String[] stringNum;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		floatNum=sc.nextFloat();
		stringNum=(floatNum+"").split("\\.");
		if (stringNum[1].charAt(0)>='5') {
			System.out.println((Integer.parseInt(stringNum[0])+1));
		}else {
			System.out.println(Integer.parseInt(stringNum[0]));
		}
	}
}
