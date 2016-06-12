package com.huawei.oj1;
import java.util.Scanner;

public class 统计字符个数 {
	private static Scanner sc;
	private static String inputData;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputData=sc.nextLine();
		int count=0;
		boolean flag=true;
		for(int i=0;i<inputData.length();i++){			
			if (inputData.charAt(i)>=0&&inputData.charAt(i)<=127) {
				flag=true;
				for(int j=i+1;j<inputData.length();j++){
					if (inputData.charAt(i)==inputData.charAt(j)) {
						flag=false;
					}
				}
				if (flag) {
					
					count++;
				}				
			}
		}
		System.out.println(count);
	}
}
