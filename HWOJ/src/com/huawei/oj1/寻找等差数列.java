package com.huawei.oj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 寻找等差数列 {
	private static Scanner sc;
	private static int max,min;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		min=sc.nextInt();
		max=sc.nextInt();
		if (min>=max||min<0) {
			System.exit(0);
		}else {
			getMaxArray(min,max);
		}
		
	}
private static void getMaxArray(int min,int max) {
	List<Integer> list=new ArrayList<>();
	List<Integer> result=new ArrayList<>();
	for(int i=min;i<=max;i++){
		for(int d=2;d<=max-i;d++){
			int k=0;
			while(i+k*d<=max&&checked(i+k*d)){
				list.add(i+k*d);
				k++;
			}
			if (list.size()>result.size()) {
				result.clear();
				result.addAll(list);
			}else if(!list.isEmpty()&&list.size()==result.size()){
				if (list.get(0)<result.get(0)) {
				result.clear();
				result.addAll(list);
				}
			}
			list.clear();
		}
	}
	for(int i=0;i<result.size();i++){
		if (i!=result.size()-1) {
			System.out.print(result.get(i)+" ");
		}else {
			System.out.print(result.get(i));
		}
	}
	System.out.println();
}

private static boolean checked(int n) {
	if (n<3) {
		return false;
	}
	for(int i=2;i<n;i++)
		if (n%i==0) {
			return false;
		}
	return true;
}
}
