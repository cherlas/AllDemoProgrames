//泛型构造方法
package com.yogurt;

class Con<T>{
	private T value;
    public void setValue(T value){
		this.value=value;
	}
    public T getValue(){
    	return value;
    }
    public Con(T value){
    	this.value=value;
    }
}
public class GenericDemo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Con<String> con=new Con<String>("构造方法中使用泛型");
	System.out.println(con.getValue());
	}

}
