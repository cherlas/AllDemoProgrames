package com.huawei.oj3;

import java.util.Scanner;

public class CubeRoot {
	private static Scanner sc;
	private static Double inputData;
	public static void main(String[] args){
		sc=new Scanner(System.in);
		inputData=sc.nextDouble();
		Double cubeResult=Math.cbrt(inputData);
		StringBuffer str=new StringBuffer(cubeResult.toString());
		str.delete(str.indexOf(".")+2, str.length());
		System.out.println(Double.parseDouble(str.toString()));
	}
}
