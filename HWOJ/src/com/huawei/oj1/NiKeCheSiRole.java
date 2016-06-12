package com.huawei.oj1;

import java.util.Scanner;

public class NiKeCheSiRole {
	private static int inputNum;
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputNum=sc.nextInt();
		if (inputNum<1||inputNum>100) {
			System.out.println("Error");
		}else if (inputNum==1) {
			System.out.println("1");
		}else{
			int k=inputNum*(inputNum-1)+1;
			String result="";
			for(int i=0;i<inputNum;i++){
				result=result+k+"+";
				k+=2;
			}
			System.out.println(result.substring(0,result.length()-1));
		}
	}
}
