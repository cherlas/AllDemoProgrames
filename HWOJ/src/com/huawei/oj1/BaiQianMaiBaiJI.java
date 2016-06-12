package com.huawei.oj1;

import java.util.Scanner;

public class BaiQianMaiBaiJI {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		sc.nextInt();
		for(int x=0;x<=20;x++){
			for(int y=0;y<=33;y++){
				for(int z=3;z<=99;z=z+3){
					if ((x+y+z==100)&&(14*x+8*y==200)) {
						System.out.println(x+" "+y+" "+z);
					}
				}
			}
		}
	}
}
