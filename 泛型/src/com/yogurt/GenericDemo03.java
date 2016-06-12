//多个泛型
package com.yogurt;
class Gen<T,K>{
	private T take;
	public T getTake() {
		return take;
	}
	public void setTake(T take) {
		this.take = take;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	private K key;
}
public class GenericDemo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String,Integer> gen=new Gen<String,Integer>();
		gen.setKey(10);
		gen.setTake("take");
		System.out.println(gen.getTake()+"  "+gen.getKey());
	}

}
