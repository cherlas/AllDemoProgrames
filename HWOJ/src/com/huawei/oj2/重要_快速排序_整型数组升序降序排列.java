package com.huawei.oj2;

import java.util.Scanner;

public class 重要_快速排序_整型数组升序降序排列 {
	private static Scanner sc;
	private static int[] inputArr;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		inputArr=new int[num];
		for(int i=0;i<num;i++)
			inputArr[i]=sc.nextInt();
		int order=sc.nextInt();
		if (order==0) {
			quickSortA(0,num-1);//升序
		}else {
			quickSortD(0,num-1);//降序
		}
		for(int i=0;i<num;i++)
		System.out.println(inputArr[i]);
	}
private static void quickSortA(int low,int high) {
	int left=low,right=high;
	if (left<right) {
		int piovt=inputArr[left];
		while(left<right){
			while(left<right&&inputArr[right]>=piovt) right--;
			if (left<right)  inputArr[left++]=inputArr[right];
			while(left<right&&inputArr[left]<=piovt) left++;
			if(left<right) inputArr[right--]=inputArr[left];
		}
		inputArr[left]=piovt;
		quickSortA(low, left-1);
		quickSortA(left+1, high);
	}
}


private static void quickSortD(int low,int high) {
	int left=low,right=high;
	if (left<right) {
		int piovt=inputArr[left];
		while(left<right){
			while(left<right&&inputArr[right]<=piovt) right--;
			if (left<right)  inputArr[left++]=inputArr[right];
			while(left<right&&inputArr[left]>=piovt) left++;
			if(left<right) inputArr[right--]=inputArr[left];
		}
		inputArr[left]=piovt;
		quickSortD(low, left-1);
		quickSortD(left+1, high);
	}
}
}
