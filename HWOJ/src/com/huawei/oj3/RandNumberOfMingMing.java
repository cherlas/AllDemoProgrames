package com.huawei.oj3;
import java.util.Arrays;
import java.util.Scanner;

public class RandNumberOfMingMing {
	private static Scanner sc;
	private static int num;
	private static int[] randNumbers;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		num=sc.nextInt();
		randNumbers=new int[num];
		for(int i=0;i<num;i ++){
			randNumbers[i]=sc.nextInt();
		}
		deleteReapt();
		Arrays.sort(randNumbers);
		print();
	}

	private static void deleteReapt() {
		for(int i=0;i<num;i++){
			for(int j=i+1;j<num;j++){
				if(randNumbers[i]!=-1&&randNumbers[i]==randNumbers[j]){
					randNumbers[j]=-1;
				}
			}
		}		
	}
	private static void print() {
		for(int i=0;i<num;i++){
			if (randNumbers[i]==-1) {
				continue;
			}else {
				System.out.println(randNumbers[i]);
			}
		}
	}
}
