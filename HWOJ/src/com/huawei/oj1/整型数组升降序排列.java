package com.huawei.oj1;

import java.util.Arrays;
import java.util.Scanner;

public class 整型数组升降序排列 {

	private static Scanner sc;
		private static int[] inputArr;
		public static void main(String[] args) {
			sc=new Scanner(System.in);
			int num=sc.nextInt();
			inputArr=new int[num];
			for(int i=0;i<num;i++)
				inputArr[i]=sc.nextInt();
			int order=sc.nextInt();
			Arrays.sort(inputArr);
			if (order==0) {
				for(int i=0;i<num;i++){
					System.out.print(inputArr[i]);
					if (i!=num-1) System.out.print(" ");
				}
			}else if (order==1) {
				for(int i=num-1;i>=0;i--){
					System.out.print(inputArr[i]);
					if (i!=0) System.out.print(" ");
				}				
			}
			System.out.println();
		}
}
