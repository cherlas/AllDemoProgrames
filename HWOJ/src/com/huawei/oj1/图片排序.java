package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class 图片排序 {
	public static void main(String[] args){
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str = null;
		try{
			str=br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		char[] cs=str.toCharArray();
		Arrays.sort(cs);
			System.out.print(cs);
	}
	
}
