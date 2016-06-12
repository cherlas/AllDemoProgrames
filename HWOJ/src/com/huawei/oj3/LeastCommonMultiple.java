package com.huawei.oj3;
import java.util.Scanner;

//辗转相除法：最小公倍数=两数乘积/最大公约数

public class LeastCommonMultiple {
	private static Scanner sc;
	private static int inputNum1,inputNum2;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputNum1=sc.nextInt();
		inputNum2=sc.nextInt();
		System.out.println(calculateCommonMultiple());
	}
private static int calculateCommonMultiple() {
	int commonMultiple=0;
	if(inputNum1%inputNum2==0){
		commonMultiple=inputNum1;
	}else if (inputNum2 % inputNum1==0) {
		commonMultiple=inputNum2;
	}else if (judePrimeNum(inputNum1)&&judePrimeNum(inputNum2)) {
		commonMultiple=inputNum1*inputNum2;
	}else{
		int smaller=inputNum1 < inputNum2 ? inputNum1 :inputNum2;
		int commonMaxPrime=1;
		for(int i=smaller-1;i>1;i--){
			if (judePrimeNum(i) && inputNum1 % i==0 && inputNum2 % i==0) {
				commonMaxPrime=i;
			}
		}
		commonMultiple=inputNum1*inputNum2/commonMaxPrime;
	}
	return commonMultiple;
 }

private static boolean judePrimeNum(int num) {
	for(int i=num-1;i>1;i--){
		if (num%i==0) {
			return false;
		}
	}
	return true;
  }
}
