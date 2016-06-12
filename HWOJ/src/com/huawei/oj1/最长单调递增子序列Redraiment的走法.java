package com.huawei.oj1;

import java.util.Scanner;

public class 最长单调递增子序列Redraiment的走法 {
	private static Scanner sc;
	private static int num;
	private static int[] height;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		num=sc.nextInt();
		height=new int[num];
		for (int i = 0; i < num; i++) 
			height[i]=sc.nextInt();
		System.out.println(getResult());
	}
private static int getResult(){
	int[] max=new int[num];
	max[num-1]=1;
	int tmp;
	for(int i=num-2;i>=0;i--){
		tmp=0;
		for(int j=i+1;j<num;j++)
			if (height[j]>height[i]&&max[j]>tmp) 
				tmp=max[j];
		max[i]=tmp+1;	
	}
	tmp=0;
	for(int i=0;i<num;i++){
		if (max[i]>tmp) {
			tmp=max[i];
		}
	}
	return tmp;
}
}
