package com.huawei.oj1;

import java.math.BigDecimal;
import java.util.Scanner;

public class SmallBallDistanceAndHeight {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int originalHeight=sc.nextInt();
		System.out.println(getJourney(originalHeight,5));
		System.out.println(getTenthHeight(originalHeight,5));
	}
public static double getJourney(int high,int n) {
	double journey=high;
	if (n==0) {
		return 0;
	}else if (n==1) {
		return getPrettyNumber(journey);
	}else if (n>2) {
		for(int i=2;i<=n;i++){
		journey+=(double)high/(Math.pow(2, i-2));
		}
	}
	
	return getPrettyNumber(journey);
  }

public static double getTenthHeight(int high,int n) {
	if (n==0) {
		return 0;
	}else {
		return getPrettyNumber((double)high/(Math.pow(2, n)));
	}
	
}
private static double getPrettyNumber(double d) {
	return BigDecimal.valueOf(d).stripTrailingZeros().doubleValue();
}
}
