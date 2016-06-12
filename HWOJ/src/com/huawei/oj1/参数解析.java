package com.huawei.oj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 参数解析 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String[] input=sc.nextLine().split(" ");
		List<String> list=new ArrayList<>();
		for(int i=0;i<input.length;){
			if (input[i].startsWith("\"")&&input[i].endsWith("\"")) {
				list.add(input[i].substring(1, input[i].length()-1));
				i++;
			}else if (input[i].startsWith("\"")&&!input[i].endsWith("\"")) {
				String tmp=input[i].substring(1, input[i].length());
				i++;
				while(!input[i].endsWith("\"")){
					tmp=tmp+" "+input[i];
					i++;
				}
				tmp+=" "+input[i].substring(0, input[i].length()-1);
				i++;
				list.add(tmp);
			}else {
				list.add(input[i]);
				i++;
			}
		}
		System.out.println(list.size());
		for(String string:list)
			System.out.println(string);
	}
}
