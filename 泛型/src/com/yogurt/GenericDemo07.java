package com.yogurt;

public class GenericDemo07 {

	public static void main(String[] args) {
		String[] arr={"11","22","33"};
		// TODO Auto-generated method stub
		tell(arr);
		Integer[] arr1={1,2,3,4};
		tell(arr1);
	}
	public static <T>void tell(T[] arr){
		for (int i= 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}