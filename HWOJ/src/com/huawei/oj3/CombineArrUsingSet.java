package com.huawei.oj3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CombineArrUsingSet {
	private static Scanner sc;
	private static Set<Integer> set;
	private static Object[] resultArr;
	public static void main(String[] args) {
		set=new HashSet<Integer>();
		sc=new Scanner(System.in);
		int pArray1=sc.nextInt();
		for(int i=0;i<pArray1;i++){
			int k=sc.nextInt();
			if (!set.contains(k)) {
				set.add(k);
			}
		}
		int pArray2=sc.nextInt();
		for(int i=0;i<pArray2;i++){
			int k=sc.nextInt();
			if (!set.contains(k)) {
				set.add(k);
		}
	}
		resultArr=set.toArray();
		Arrays.sort(resultArr);
		for(int i=0;i<resultArr.length;i++){
			System.out.print(resultArr[i]);
		}

		
	}
}
