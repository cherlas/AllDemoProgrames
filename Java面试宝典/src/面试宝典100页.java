

import java.util.ArrayList;
import java.util.List;

public class 面试宝典100页 {
	private String value=null;
	public 面试宝典100页(String v){
		value=v;
	}
	public boolean equals(面试宝典100页 o){
		if (o==this) 
			return true;
		if (o instanceof 面试宝典100页) {
			面试宝典100页 test=(面试宝典100页) o;
			System.out.println(value);
			return value.equals(test.value);
		}
		return false;
	}
	public static void main(String[] args) {
		List list=new ArrayList<>();
		面试宝典100页 test1=new 面试宝典100页("object");
		面试宝典100页 test2=new 面试宝典100页("object");
		面试宝典100页 test3=new 面试宝典100页("object");
		Object test4=new 面试宝典100页("object");
		list.add(test1);
		System.out.println("test1  "+test1);
		System.out.println("test2  "+test2);
		System.out.println("test3  "+test3);
		System.out.println("test4  "+test4);
		System.out.println(list.contains(test2));
		System.out.println(test2.equals(test3));
		System.out.println(test3.equals(test4));
	}
	
}