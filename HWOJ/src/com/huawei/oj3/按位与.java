package com.huawei.oj3;

public class 按位与 {

	public static void main(String[] args) {
		String str1 = "0101";
		String str2 = "0111";
		int int1 = Integer.parseInt(str1, 2);
		int int2 = Integer.parseInt(str2, 2);

		System.out.println(Integer.toBinaryString(int1));
		System.out.println(Integer.toBinaryString(int2));
		int1 = int1 & int2;
		System.out.println(Integer.toBinaryString(int1));

	}

}
