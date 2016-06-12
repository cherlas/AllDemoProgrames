package com.huawei.oj1;

import java.util.Scanner;

public class OKPasswords {
	private static Scanner sc;
	private static String passwords;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			passwords=sc.nextLine();
			System.out.println(checkPasswords(passwords));
		}		
	}
	
	private static String checkPasswords(String str) {
		
		if (str.length()<=8) {
			return "NG";
		}else {
			int checkNum=0,checkBigLetter=0,checkSmallLetter=0,checkOthers=0;
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if (c>='a'&&c<='z') {
					checkSmallLetter=1;
				}else if (c>='A'&&c<='Z') {
					checkBigLetter=1;
				}else if (c>='0'&&c<='9') {
					checkNum=1;
				}else {
					checkOthers=1;
				}
			}
			if (checkSmallLetter+checkBigLetter+checkNum+checkOthers<3) {
				return "NG";
			}
			for(int i=0;i<str.length();i++){
				for(int j=i+2;j<str.length();j++){
					StringBuffer sb=new StringBuffer(str);
					sb.replace(i, j, "");
					if(sb.toString().contains(str.substring(i,j)))
						return "NG";
				}
			}
		}	
		return "OK";
	}
}
