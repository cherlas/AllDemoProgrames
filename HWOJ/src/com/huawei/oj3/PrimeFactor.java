package com.huawei.oj3;
import java.util.Scanner;

public class PrimeFactor {
	private static Scanner sc;
	private static String result="";
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		long number=sc.nextLong();
		
		System.out.println(searchFactors(number,2,result).substring(0,result.length()-1));

	}
public static String searchFactors(Long numbers,int m,String res) {
	if (numbers<m) {
		result=res;
	}else {
		if (numbers%m==0) {		
		searchFactors(numbers/m, m,res+m+" ");
	}else {
		searchFactors(numbers, m+1,res);
		}
	}	
	return result;
	}
}
