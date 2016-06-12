package com.huawei.oj3;
import java.util.Arrays;
import java.util.Scanner;

public class CombineArr {

	private static Scanner sc;
	private static int[] arr1,arr2,resultArr;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int pArray1=sc.nextInt();
		arr1=new int[pArray1];
		for(int i=0;i<pArray1;i++){
			arr1[i]=sc.nextInt();
		}
		int pArray2=sc.nextInt();
		arr2=new int[pArray2];
		for(int i=0;i<pArray2;i++){
			arr2[i]=sc.nextInt();
		}
		resultArr=new int[pArray1+pArray2];
		for(int i=pArray1-1;i>=0;i--){
			resultArr[pArray1-i-1]=arr1[i];
		}
		for(int j=pArray2-1;j>=0;j--){
			resultArr[pArray2-j-1+pArray1]=arr2[j];
		}
		sort(resultArr);
		print(resultArr);
	}
	
	private static void sort(int[] arr) {
		Arrays.sort(arr);
	}
	
	private static void print(int[] arr) {
		int k=arr[0];
		System.out.print(k);		
		for(int i=1;i<arr.length-1;){
			while(arr[i]==k){
				i++;
			}
			k=arr[i];
			i++;
			System.out.print(k);
		}
	}
}
