package com.huawei.oj3;
import java.util.Arrays;
import java.util.Scanner;

public class TheSmallestK {
	private static Scanner sc;
	private static int n,k;
	private static int[] nums;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		for(int i=0;i<k-1;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println(nums[k-1]);
	}

}
