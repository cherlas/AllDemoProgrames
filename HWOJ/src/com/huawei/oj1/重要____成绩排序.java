package com.huawei.oj1;

import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;
class person implements Comparable<Object>{
	String name;
	int score;
	int order;
	public person(String name,int score,int order) {
		this.name=name;
		this.score=score;
		this.order=order;
	}
	@Override
	public int compareTo(Object o) {
		person p=(person)o;
		if (this.order==1) {
			if (this.score>p.score) {
				return 1;
			}else if(this.score<p.score) {
				return -1;
			}else if (this.score==p.score) {
				return 1;
			}
		}else if (order==0) {
			if (this.score<p.score) {
				return 1;
			}else if(this.score>p.score) {
				return -1;
			}else if (this.score==p.score) {
				return 1;
			}
		}
		return 0;
	}
	
}
public class 重要____成绩排序 {
	private static Scanner sc;
	private static Map<person, Integer> map=new TreeMap<>();
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		int order=sc.nextInt();
		for(int i=0;i<num;i++){
			String name=sc.next();
			int score=sc.nextInt();
			map.put(new person(name,score,order), new Integer(order));
		}
			
			for(person string:map.keySet())
			System.out.println(string.name+" "+string.score);
		
		
	}

}
