package 华为武汉长沙地区实习招聘;

import java.util.Scanner;

public class 拼接 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String input=sc.nextLine();
		if(input.length()>255){
			System.exit(0);
		}else {
			for(int i=input.length()-1;i>=0;i--){
				char c=input.charAt(i);
				if (c==' ') 
					continue;
				if (c>='a'&&c<='z') {
					System.out.print((char)(c-32));
				}else {
					System.out.print((char)(c+32));
				}
			}
			System.out.println();
		}
		
	}
}
	
