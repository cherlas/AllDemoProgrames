//通配符
package com.yogurt;
class Info<T>{
	private T info;
	public void setInfo(T info) {
		this.info = info;
	}
	public T getInfo() {
		return info;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getInfo().toString();
	}
}
public class GenericDemo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info<String> i=new Info<String>();
		i.setInfo("abcd");
		tell(i);
	}
	/**
	 * 通配符：？
	 * @param info
	 */
public static void tell(Info<?> info){
	System.out.println(info);
}
}
