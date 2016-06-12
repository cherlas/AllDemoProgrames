package com.huawei.oj1;

import java.util.Scanner;

public class 句子反转 {
	private static Scanner sc;
	private static String[] words;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str=sc.nextLine();
		words=str.split(" ");
		System.out.println(inverse());
	}
	private static String inverse() {
		String string="";
		int low=0,high=words.length-1;
		while(low<high){
			String tmp=words[low];
			words[low]=words[high];
			words[high]=tmp;
			low++;
			high--;
		}
		for(int i=0;i<words.length;i++){
			if (i!=words.length-1) {
				string =string+words[i]+" ";
			}else {
				string=string+words[i];
			}
			
		}
		return string;
	}
}
