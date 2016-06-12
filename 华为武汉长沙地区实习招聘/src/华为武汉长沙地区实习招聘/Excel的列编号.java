package 华为武汉长沙地区实习招聘;

import java.util.Scanner;

public class Excel的列编号 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		System.out.println(calculate(sc.nextLine()));

	}
private static String calculate(String str) {
	int result=0;
	for(int i=0;i<str.length();i++){
		char c=str.charAt(i);
		result=(int) (result+(int)(c-96)*Math.pow(26, str.length()-1-i));
	}	
	return String.valueOf(result);
}
}
