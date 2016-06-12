package com.huawei.oj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 识别有效的IP地址和掩码并进行分类统计 {
	private static Scanner sc;
	private static List<String> inputList=new ArrayList<>();
	private static int[] nums=new int[7];
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int flag=0;
		while(flag<4){
			inputList.add(sc.nextLine());
			flag++;
		}
		for(int i=0;i<inputList.size();i++){
			List<Integer> list=checked(inputList.get(i));
			for(int j=0;j<list.size();j++)
				nums[list.get(j)]++;
			
		}
		
		for(int i=0;i<7;i++){
			System.out.print(nums[i]);
			if (i!=6) 
				System.out.print(" ");
		}
	}
private static List<Integer> checked(String str) {
	String[] ipAndMask=str.split("~");
	List<Integer> result=new ArrayList<>();
	//System.out.println(isLeagalIp(ipAndMask[0])+"   "+isLeagalMask(ipAndMask[1]));
	if (!isLeagalIp(ipAndMask[0])||!isLeagalMask(ipAndMask[1])) {
		result.add(new Integer(5));
	}else {
		int a1=ipAndMask[0].indexOf(".");
		int num1=Integer.parseInt(ipAndMask[0].substring(0, a1));
		if(num1>=1&&num1<=126){
			result.add(new Integer(0));
			if (num1==10) {
				result.add(6);
			}
		}else if (num1>=128&&num1<=191) {
			result.add(new Integer(1));
			int a2=ipAndMask[0].indexOf(".",a1+1);
			int num2=Integer.parseInt(ipAndMask[0].substring(a1+1, a2));
			if (num1==172&&num2>=16&&num2<=31) {
				result.add(new Integer(6));
			}
		}else if (num1>=192&&num1<=223) {
			result.add(new Integer(2));
			int a2=ipAndMask[0].indexOf(".",a1+1);
			int num2=Integer.parseInt(ipAndMask[0].substring(a1+1, a2));
			if (num1==192&&num2==168) {
				result.add(new Integer(6));
			}
		}else if (num1>=224&&num1<=239) {
			result.add(3);
		}else if (num1>=240&&num1<=255) {
			result.add(new Integer(4));
		}
	}
//	for(Integer i:result)
//		System.out.print(i+"   ");
//	System.out.println();
	return result;
}

private static boolean isLeagalIp(String str) {
	
		int a1=str.indexOf(".");
		if (a1<0||Integer.parseInt(str.substring(0, a1))>255||Integer.parseInt(str.substring(0, a1))<0) {
			return false;
		}
		int a2 = 0;
		while(a1!=-1){
			a2=str.indexOf(".",a1+1);

			if(a2==-1) break;
			if (a2-a1==1) {
				return false;
			}
			String string=str.substring(a1+1,a2);
			
			if (string.length()==0||Integer.parseInt(string)<0||Integer.parseInt(string)>255) {
				System.out.println("aa");
				return false;
			}
			a1=a2;
		}
		if (Integer.parseInt(str.substring(a1+1,str.length()))>255) {
			return false;
		}
	
	return true;
}

private static boolean isLeagalMask(String str) {
	StringBuffer sb=new StringBuffer();
	int a1=str.indexOf(".");
	int a2=0;
	sb.append(Integer.toBinaryString(Integer.parseInt(str.substring(0,a1))));
	while(a1!=-1){
		a2=str.indexOf(".",a1+1);
		if(a2==-1) break;
		if (a2-a1==1) {
			return false;
		}
		sb.append(Integer.toBinaryString(Integer.parseInt(str.substring(a1+1,a2))));
		a1=a2;
	}
	sb.append(Integer.toBinaryString(Integer.parseInt(str.substring(a1+1,str.length()))));
	a1=sb.indexOf("0");
	if (sb.substring(a1,sb.length()).contains("1")) {
		return false;
	}
	return true;
}
}
