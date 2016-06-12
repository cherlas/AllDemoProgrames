package com.huawei.oj1;
/**
 * 等差数列
 * 功能:等差数列 2，5，8，11，14。。。。
	输入:正整数N >0
	输出:求等差数列前N项和
	返回:转换成功返回 0 ,非法输入与异常返回-1
 */
import java.util.Scanner;

public class ArithmeticProgression {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println((n*2+n*(n-1)/2*3));
	}
}
