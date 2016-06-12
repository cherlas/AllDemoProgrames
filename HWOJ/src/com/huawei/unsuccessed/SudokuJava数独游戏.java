package com.huawei.unsuccessed;

import java.util.Scanner;

public class SudokuJava数独游戏 {
	private static Scanner sc;
	private static int[][] game=new int[9][9];
	public static void main(String[] args) {
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				game[i][j]=sc.nextInt();
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if (game[i][j]==0&&judge(i,j)) {
					
				}
			}
		}
System.out.println();
	}
private static boolean judge(int r,int c) {
	for(int i=1;i<=9;i++){
		
	}
	return true;
}

private static boolean sumBlock(int  i,int j) {
	
	
	return true;
}
}
