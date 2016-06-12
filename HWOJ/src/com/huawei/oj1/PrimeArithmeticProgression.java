package com.huawei.oj1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 题目标题：
	在给定的区间范围内找出所有素数能构成的最大的等差数列（即等差数列包含的素数个数最多）。
	 
	详细描述：
	接口说明
	原型：
	 public static int[] GetMaxArray( int m,  int n)
	输入参数：
	int m 给定的区间下限
	int n 给定的区间上限
	返回值：	 
	 等差数列	 
	限制：
	0 <= m<= n
	举例：
	在区间[0, 10]中，素数构成的最大等差数列为3,5,7
 */
public class PrimeArithmeticProgression {
	private static Scanner sc;
	private static int minNum,maxNum;
	private static int[] temp1;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		minNum=sc.nextInt();
		maxNum=sc.nextInt();
		int result[]= getMaxArray(minNum,maxNum);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
public static int[] getMaxArray(int m,int n){
	Object[] result1=null;
	int[] result=null;
	temp1=new int[n-m+1];
	int flag=0;
	for(int i=m;i<=n;i++){
		if(checkedNum(i)){
			temp1[flag]=i;
			flag++;
		}
	}
	ArrayList<Integer> tempList=new ArrayList<>();
	ArrayList<Integer> resultList=new ArrayList<>();
	for(int i=0;i<flag;i++){
		
		for(int j=2;j<=temp1[flag-1]-temp1[i];j++){
			int d=0;
			tempList.clear();
			while(checked(temp1[i]+j*d,flag)){				
				tempList.add((temp1[i]+j*d));
				d++;
			}
			if (tempList.size()>resultList.size()) {
				resultList.clear();
				resultList.addAll(tempList);
			}else if(tempList.size()==resultList.size()) {
				if (tempList.get(tempList.size()-1)>resultList.get(resultList.size()-1)) {
					resultList.clear();
					resultList.addAll(tempList);
				}
			}
		}
	}
	result1=resultList.toArray();
	result=new int[result1.length];
	for(int i=0;i<result.length;i++){
		result[i]=(int)result1[i];
	}
	return result;
}

private static boolean checkedNum(int num) {
	if (num==1||num==0) {
		return false;
	}
	for(int i=2;i<num;i++){
		if (num%i==0) {
			return false;
		}
	}
	return true;
}

private static boolean checked(int num,int flag) {
	for(int i=0;i<flag;i++){
		if (num==temp1[i]) {
			return true;
		}
	}
	return false;
}
}
