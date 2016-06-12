package com.huawei.oj3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DeleteLeastChar {
	private static Scanner sc;
	private static String inputString;
	private static StringBuffer sb;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputString=sc.nextLine();
		if (inputString.length()>20) {
			System.out.println(inputString);
		}else if (!judge()) {
			System.out.println(inputString);
		}else {
			
			deleteChar();
		}	
	}
private static void deleteChar(){
	Map<Character, Integer> map=new HashMap< Character,Integer>();
	for(int i=0;i<inputString.length();i++){
		if (map.containsKey(inputString.charAt(i))) {
			int value=map.get(inputString.charAt(i))+1;
			map.put(inputString.charAt(i), value);
		}else {
			map.put(inputString.charAt(i), 1);
		}
	}
	int max=inputString.length();
	for(Integer i:map.values()){
		if(max>=i){
			max=i;
		}
	}
	ArrayList<Character> list=new ArrayList<Character>();
	Iterator<Character> it=map.keySet().iterator();
	while(it.hasNext()){
		char c=it.next();
		if (map.get(c)==max) {
			it.remove();
			list.add(c);
			map.remove(c);
		}
	}
	sb=new StringBuffer();
	outer:
	for(int i=0;i<inputString.length();i++){
		for(int j=0;j<list.size();j++){
			if (inputString.charAt(i)==list.get(j)) {
				continue outer;
			}
		}
		sb.append(inputString.charAt(i)+"");
	}
	System.out.println(sb);	
  }
private static boolean judge() {
	for(int i=0;i<inputString.length();i++){
		if (!(inputString.charAt(i)>='a'&&inputString.charAt(i)<='z')) {
			return false;
		}
	}
	return true;
  }
}
