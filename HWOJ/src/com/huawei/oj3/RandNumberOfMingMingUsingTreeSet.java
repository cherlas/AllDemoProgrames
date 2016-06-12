package com.huawei.oj3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class RandNumberOfMingMingUsingTreeSet {
	private static Scanner sc;
	private static int num;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNextInt()){
		num=sc.nextInt();
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int i=0;i<num;i++){
			int input=sc.nextInt();
			ts.add(input);
		}
		for(Integer i:ts){
            System.out.println(i);
        }
	  }
	}
}
