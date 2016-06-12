package com.huawei.oj3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CombineRecords {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		Map<Integer, Integer> oriRecords=new HashMap<>();
		for(int i=0;i<num;i++){
			int index=sc.nextInt();
			int value=sc.nextInt();
			if(oriRecords.containsKey(index)){
				value+=oriRecords.get(index);
				oriRecords.remove(index);
				oriRecords.put(index, value);
			}else {
				oriRecords.put(index, value);
			}
		}	
		for (Integer key :oriRecords.keySet()) {
			System.out.println(key);
			System.out.println(oriRecords.get(key));
		}
	}
}
