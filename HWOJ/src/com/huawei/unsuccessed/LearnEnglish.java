package com.huawei.unsuccessed;
import java.util.Scanner;

public class LearnEnglish {
	
	private static Long num;
	private static Scanner sc;
	private static String[] numbers=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
	private static String[] keyWords=new String[]{"and","hundred","shousand","million","billion"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		num=sc.nextLong();
		String string=parse(num);
		System.out.println(string);
	}

	public static String parse(long num) {
		
		String str = null;
		String stringNum=String.valueOf(num);
		if (num<0||stringNum.length()>10) {
			return "error";
		}
		String string="";
		String[] threeNum=new String[stringNum.length()/2+1];
		int k=0,flag=0;
		for(int i=stringNum.length();i>2;i=i-3){
			if(i-3==0){
				string=stringNum.substring(i-3,i)+string;
				threeNum[flag]=string;
				flag++;
			}else {
				string=','+stringNum.substring(i-3,i)+string;
				threeNum[flag]=string;
				flag++;
			}
			k=i-2;
		}
		flag=0;
		string=stringNum.substring(0,k-1)+string;
		for(int i=string.length()-1;i>=0;i--){
			if(string.charAt(i)==','){
				flag++;
				str=" "+keyWords[flag]+string;
				continue;
			}
			
			
		}

		return str;
	}
}
