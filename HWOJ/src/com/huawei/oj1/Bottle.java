package com.huawei.oj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bottle {
	private static Scanner sc;
	private static List<Integer> list=new ArrayList<>();
	public static void main(String[] args) {
		int in;
		sc=new Scanner(System.in);
		while((in=sc.nextInt())!=0)
			list.add(in);
		
		calculateBottle();
	}
private static void calculateBottle() {
	for(Integer num:list){
		if (num<3) {
			System.out.println(0);
		}else {
			int count=0,empty=num,tmp1=0,tmp2=0;
			while(empty>=3){
				tmp1=empty/3;
				count+=tmp1;
				tmp2=empty%3;
				empty=tmp1+tmp2;
			}
			if (empty==2) {
				count++;
			}			
			System.out.println(count);
		}
	}
}
}
