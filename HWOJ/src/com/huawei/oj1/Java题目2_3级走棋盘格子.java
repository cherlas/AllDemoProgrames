package com.huawei.oj1;

import java.util.Scanner;

public class Java题目2_3级走棋盘格子 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] s=new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			s[i][0]=1;
		for(int i=0;i<=m;i++)
			s[0][i]=1;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++)
				s[i][j]=s[i-1][j]+s[i][j-1];
		System.out.println(s[n][m]);
	}
}
