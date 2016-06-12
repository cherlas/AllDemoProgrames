package com.huawei.unsuccessed;

import java.math.BigDecimal;
import java.util.Scanner;

public class PrimeNumPartnerMoving {
	private static Scanner sc;
	private static int[] nums;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int allNum=sc.nextInt();
		if (allNum<2||allNum%2!=0||allNum>30000) {
			System.out.println("Error");
		}else {
			nums=new int[allNum];
			int[] dp=new int[allNum];
			for(int i=0;i<allNum;i++){
				nums[i]=sc.nextInt();
				dp[i]=0;
			}
			int cnt=0;
			for(int i=1;i<allNum;i++){
				for(int j=i+1;j<allNum;j++){
					cnt=checkNum(nums[i]+nums[j]) ? dp[i-1]+dp[j-1]-dp[j]+1:dp[i-1];
					dp[i]=Math.max(cnt, dp[i]);
				}
			}
			System.out.println(dp[allNum-2]);
		}

	}
private static boolean checkNum(int num) {
		for(int i=2;i<Math.sqrt((double)num);i++){
			if (num%i==0) {
				return false;
			}
		}
		return true;
	}
}