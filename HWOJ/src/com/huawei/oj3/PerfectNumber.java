package com.huawei.oj3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		long n=sc.nextInt();
		int num=count(n);
		System.out.println(num);
	}
public static int  count(long n) {
	if (n==1||n==0) {
		return -1;
	}
	int num=0;
	for(long i=2;i<=n;i++){
	ArrayList<Long> list=new ArrayList<>(); 
	for(long j=1;j<i;j++ ){
		if (i%j==0) {
			list.add(j);
			//list.ensureCapacity(65535);;
		}
	}
	long sum=0;
	for(int j=0;j<list.size();j++){
		sum+=list.get(j);
	}
	
	if(sum==i) num++;
	list.clear();
	}
	return num;
  }
}
