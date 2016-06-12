package com.yogurt.generic;

class Intter{
	public <T>T tell(T t){
		return t;
	}
}
public class GenericDemo06 {
	public static void mian(String[] args){
		Intter intter=new Intter();
//		String str=intter.tell("zlz");
//		System.out.println(str);
		Integer i=intter.tell(10);
		System.out.println(i);
	}
}
