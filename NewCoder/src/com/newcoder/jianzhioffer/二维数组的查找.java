package com.newcoder.jianzhioffer;

import java.util.Scanner;

public class 二维数组的查找 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int[][] input=new int[4][4];
		int target=sc.nextInt();
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				input[i][j]=sc.nextInt();
		if (Find(input, target)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
private static boolean Find(int[][] array,int target) {
	int i=0,j=array[0].length-1;
	while(i<array.length&&j>=0)
		if (array[i][j]==target) 
			return true;
		else if (array[i][j]>target) 
			j--;
		else 
			i++;			
	return false;
}
}
