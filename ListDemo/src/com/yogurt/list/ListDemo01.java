package com.yogurt.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lists=null;
		lists=new ArrayList<String>();
		lists.add("A");
		lists.add("B");
		lists.add("A");
		for(int i=0;i<lists.size();i++){
			System.out.println(lists.get(i));
		}
		
		System.out.println("集合是否为空: "+lists.isEmpty());
		System.out.println("集合中是否含有A: "+lists.indexOf("A"));
		System.out.println("集合中是否含有C: "+lists.indexOf("B"));
		System.out.println("集合中是否含有B: "+lists.indexOf("C"));
		lists.remove(0);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
	}

}
