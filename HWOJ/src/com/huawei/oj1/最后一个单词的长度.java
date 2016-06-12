package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class 最后一个单词的长度 {
	static String str;
	public static void main(String[] args) {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try {
			str=br.readLine();
		} catch (Exception e) {
			// TODO: handle exception
		}
		int k=str.lastIndexOf(" ");
	
		System.out.println((str.length()-k-1));
	}

}
