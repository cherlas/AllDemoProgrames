package 华为武汉长沙地区实习招聘;

import java.util.Scanner;

public class 新字符串拼接 {
	private static Scanner sc;
	private static String[] strings;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String input=sc.nextLine();
		if(input.length()>255){
			System.exit(0);
		}else {
			strings=input.split(" ");
			reverse();
		}
		
	}
	
private static void reverse() {
	for(int j=0;j<strings.length;j++){
	for(int i=strings[j].length()-1;i>=0;i--){
		char c=strings[j].charAt(i);
		if (c>='a'&&c<='z') {
			System.out.print((char)(c-32));
		}else {
			System.out.print((char)(c+32));
		}
	}
	}
	System.out.println();
}
}
