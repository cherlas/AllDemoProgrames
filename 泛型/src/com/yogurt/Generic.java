//泛型  Generic
package com.yogurt;

class Point<T>{
	private T x;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	private T y;
	
}
public class Generic {
	public static void main(String[] args){
		Point<String> p=new Point<String>();
		p.setX("10");
		p.setY("10");
		System.out.println(p.getX()+"     "+p.getY());
	}
}
