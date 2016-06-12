package com.huawei.oj1;

import java.util.Scanner;

public class FindPrimeNum {
public static class PrimePair{
	public int primeMin;
	public int primeMax;
}

private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int inputNum;
		inputNum=sc.nextInt();
		if (inputNum<=5||inputNum%2!=0||inputNum>10000) {
			System.out.println("Error");
		}else {
			System.out.println(findPrimeNumber(inputNum).primeMin);
			System.out.println(findPrimeNumber(inputNum).primeMax);
		}
	}
	
	private static PrimePair findPrimeNumber(int number) {
		PrimePair pair=new PrimePair();
		int min=number/2;
		int max=number/2;
		while(min>=3&&max<=number-3){
			if (checkNum(min)&&checkNum(max)&&(min+max==number)) {
				pair.primeMin=min;
				pair.primeMax=max;
				break;
			}else {
				min--;
				max++;
			}
		}		
		return pair;
	}
	
	private static boolean checkNum(int num) {
		for(int i=2;i<num-1;i++){
			if (num%i==0) {
				return false;
			}
		}
		return true;
	}
}
