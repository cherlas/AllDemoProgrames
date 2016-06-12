package com.yogurt.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lists=null;
		lists=new ArrayList<String>();
		lists.add("A");
		lists.add("B");
		lists.add("C");
		lists.add("D");
		lists.add("E");
		Iterator<String> iterator=lists.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}

}
