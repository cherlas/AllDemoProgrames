package com.huawei.oj1;

import java.util.Scanner;

public class StringSeparateMedia {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		String[] inputString=new String[num];
		int flag=0;
		while(flag<num){
			inputString[flag]=sc.next();
			flag++;
		}
		for(int i=0;i<inputString.length;i++){
			while(inputString[i].length()%8!=0){
				inputString[i]+="0";
			}
		}
		for(int i=0;i<inputString.length;i++){
			if (inputString[i].length()==0) {
			System.out.println();
			}
		}
		for(int i=0;i<num;i++){
			if (inputString[i].length()==8) {
				System.out.println(inputString[i]);
			}else {
				for(int j=0;j<inputString[i].length();j++){
					if (j%8==7) {
						System.out.println(inputString[i].charAt(j));
					}else {
						System.out.print(inputString[i].charAt(j));
					}
				}
			}
			
		}
	}

}
