package com.y;
class Genner{
	public <T>T tell(T t){
		return t;
	}
}
public class GenericWrongDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Genner g=new Genner();
		String str=g.tell("zlz");
		System.out.println(str);
		int i=g.tell(10);
		System.out.println(i);
		System.out.println("雷".length());
	}

}
