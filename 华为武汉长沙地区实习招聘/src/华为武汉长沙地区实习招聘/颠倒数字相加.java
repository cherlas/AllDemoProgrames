package 华为武汉长沙地区实习招聘;

import java.math.BigDecimal;
import java.util.Scanner;

public class 颠倒数字相加 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		System.out.println(reverseAdd(num1,num2));
	}

	private static int reverseAdd(int num1,int num2) {
		String str1=String.valueOf(num1);
		String str2=String.valueOf(num2);
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		for(int i=str1.length()-1;i>=0;i--){
			sb1.append(str1.charAt(i));
		}
		for(int i=str2.length()-1;i>=0;i--){
			sb2.append(str2.charAt(i));
		}
		return Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());
	}
}
