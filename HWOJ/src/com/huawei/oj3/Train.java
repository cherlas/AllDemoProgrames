package com.huawei.oj3;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
	private static int[] original=null;
	private static Scanner sc;
	private static int numOfTrain;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		numOfTrain=sc.nextInt();
		sc.nextLine();
		original=new int[numOfTrain];
		for(int i=0;i<numOfTrain;i++){
			original[i]=sc.nextInt();
		}
		
		outTrainState(original);
	}
private static void outTrainState(int[] state) {
	int fromIndex,endIndex,changeIndex;
	sort(0, numOfTrain-1);
	do{
		output();
		fromIndex=endIndex=numOfTrain-1;
		while(fromIndex>0&&original[fromIndex-1]>original[fromIndex]) --fromIndex;
		changeIndex=fromIndex;
		if (fromIndex==0) 
			break;
		while(changeIndex+1<numOfTrain&&original[changeIndex+1]>original[fromIndex-1]) ++changeIndex;
		
		swap(fromIndex-1,changeIndex);
		invertArray(fromIndex,endIndex);
		}while(true);
	
	
	}

private static void sort(int fromIndex,int endIndex) {
	Arrays.sort(original,fromIndex,endIndex-fromIndex+1);
	}

private static void output() {
	for(int i=0;i<numOfTrain-1;i++){
		System.out.print(original[i]+" ");
	}
	System.out.println(original[numOfTrain-1]);
  }

private static void swap(int fromIndex,int changeIndex) {
	int tmp=original[fromIndex];
	original[fromIndex]=original[changeIndex];
	original[changeIndex]=tmp;
 }

private static void invertArray(int fromIndex,int endIndex) {
	while(fromIndex<endIndex){
		swap(fromIndex, endIndex);
		fromIndex++;
		endIndex--;
	}
	
 }
}
