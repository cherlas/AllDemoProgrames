package com.huawei.oj1;

import java.util.Scanner;

public class 兔子繁殖 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int mounth=sc.nextInt();
		if(mounth<3){
			System.out.println(1);
		}else {
			int[] f=new int[mounth+1];
			f[1]=1;f[2]=1;
			for(int i=3;i<=mounth;i++){
				f[i]=f[i-1]+f[i-2];
			}
			System.out.println(f[mounth]);
		}
	}
}
