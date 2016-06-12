package com.huawei.oj1;

import java.util.Scanner;

public class PasswordSecurityLevel {
	private static Scanner sc;
	private static String password;
	private static String[] level=new String[]{"VERY_SECURE","SECURE","VERY_STRONG","STRONG","AVERAGE","WEAK","VERY_WEAK"};
	
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		password=sc.nextLine();
		System.out.println(level[GetPwdSecurityLevel(password)]);
	}
	public static int  GetPwdSecurityLevel(String pPasswordStr){
		int psLevel=0;
		int countLength=0,countBigLetter=0,countSmallLetter=0,countNum=0,countSymbol=0,countSum=0,countLetter=0;
		for(int i=0;i<pPasswordStr.length();i++){
			char ch=pPasswordStr.charAt(i);
			if (ch>='A'&&ch<='Z') {
				countBigLetter++;
				countLetter++;
			}else if (ch>='0'&&ch<='9') {
				countNum++;
			}else if (ch>=0x21&&ch<=0x2F||ch>=0x3A&&ch<=0x40||ch>=0x5B&&ch<=0x60||ch>=0x7B&&ch<=0x7E) {
				countSymbol++;
			}else if (ch>='a'&&ch<='z') {
				countSmallLetter++;
				countLetter++;
			}	
		}
		//长度
		if (pPasswordStr.length()<=4) {
			countLength=5;
		}else if (pPasswordStr.length()>4&&pPasswordStr.length()<=7) {
			countLength=10;
		}else {
			countLength=25;
		}
		countSum+=countLength;
		//字母
		if (countBigLetter==0&&countSmallLetter==0) {
			countSum+=0;
		}else if (countBigLetter==0&&countSmallLetter!=0||countBigLetter!=0&&countSmallLetter==0) {
			countSum+=10;
		}else if(countBigLetter!=0&&countSmallLetter!=0){
			countSum+=20;
		}
		//数字
		if (countNum==0) {
			countSum+=0;
		}else if (countNum==1) {
			countSum+=10;
		}else {
			countSum+=20;
		}
		//符号
		if (countSymbol==0) {
			countSum+=0;
		}else if (countSymbol==1) {
			countSum+=10;
		}else {
			countSum+=25;
		}
//		System.out.println(countBigLetter+"  "+countSmallLetter+" "+countLetter);
//		System.out.println(pPasswordStr.length()+" "+countSymbol+"  "+countNum);
//		System.out.println();
//		System.out.println(countSum);
		//奖励
		if (countBigLetter!=0&&countSmallLetter!=0&&countNum!=0&&countSymbol!=0) {
			countSum+=5;
		}
		else if (countLetter!=0&&countNum!=0&&countSymbol!=0) {
			countSum+=3;
		}
		else if (countLetter!=0&&countSymbol!=0) {
			countSum+=2;
		}
		//System.out.println(countSum);
		if (countSum>=90) {
			return 0;
		}else if (countSum>=80) {
			return 1;
		}else if (countSum>=70) {
			return 2;
		}else if (countSum>=60) {
			return 3;
		}else if (countSum>=50) {
			return 4;
		}else if (countSum>=25) {
			return 5;
		}else if (countSum>=0) {
			return 6;
		}
		
		return psLevel;
	}
}
