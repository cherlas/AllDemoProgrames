package com.huawei.oj1;

import java.util.Scanner;

public class DNAOrder {
	private static Scanner sc;
	private static String dna;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		dna=sc.nextLine();
		int len=sc.nextInt();		
		if (len>dna.length()) {
			System.out.println("Error");
		}else {
			double gcRatio=0.0;
			String maxGCRatioString="";
			for(int i=0;i<=dna.length()-len;i++){
				for(int j=len+i;j<=dna.length();j++){
					double ratio=calculateGCRatio(dna.substring(i,j));
				if (ratio>gcRatio) {
					maxGCRatioString=dna.substring(i,j);
					gcRatio=ratio;
				}
				}			
			}
			System.out.println(maxGCRatioString);
		}
	}

	private static double calculateGCRatio(String str) {
		int count=0;
		for(int i=0;i<str.length();i++){
			if (str.charAt(i)=='C'||str.charAt(i)=='G') {
				count++;
			}
		}
		return ((double)count/str.length());
	}
}
