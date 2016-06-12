package com.huawei.oj3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HW201301 {
	private static Scanner sc;
	private static int num;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		num=sc.nextInt();
		int[] numbers=new int[num];
		for(int i=0;i<num;i++){
			numbers[i]=sc.nextInt();
		}
		System.out.println(separateArray(numbers));
	}
	private static String separateArray(int[] numbers) {
		int three=0,five=0;
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<num;i++){
			if (numbers[i]%5==0&&numbers[i]%3==0) {
				list.add(numbers[i]);
				continue;
			}else if (numbers[i]%3==0) {
				three+=numbers[i];				
			}else if (numbers[i]%5==0) {
				five+=numbers[i];
			}else {
				list.add(numbers[i]);
			} 
		}
		if(!list.isEmpty()&&three==five){
			return "true";
		}else {
			Object[] other=list.toArray();
			Arrays.sort(other);
			int otherThree=0,otherFive=0;
			if(three>=five){
			for(int i=-1;i<other.length;i++){
				otherFive=0;
				otherThree=0;
					for(int j=0;j<=i;j++){
						otherThree+=(int)other[j];
					}
					for(int j=i+1;j<other.length;j++){
						otherFive+=(int)other[j];
					}
					if((otherFive+five)==(three+otherThree)){
						return "true";
					}
				}
			}else {
					for(int i=-1;i<other.length;i++){
						otherFive=0;
						otherThree=0;
					for(int j=0;j<=i;j++){
						otherFive+=(int)other[j];
					}
					for(int j=i+1;j<other.length;j++){
						otherThree+=(int)other[j];
					}
					if((otherFive+five)==(three+otherThree)){
						return "true";
					}
				}		
			}
			return "false";
		}		
	}
}
