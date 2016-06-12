//泛型接口
package com.yogurt;

interface GenInter<T>{
	public void say();
}

class Gin<T> implements GenInter<T>{

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("zlz");
	}
	
}
public class GenericDemo05 {
	public static void main(String[] args) {
		Gin<String> gin=new Gin<String>();
		gin.say();
	}
}
