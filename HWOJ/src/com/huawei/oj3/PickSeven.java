package com.huawei.oj3;
import java.util.Scanner;
class PickSeven {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n=sc.nextInt();
		int flag=0;
		if(n==0){
			System.out.println(0);
			System.exit(0);
			}else if (n>30000) {
				System.out.println("Input Error");
			}
		for(int i=1;i<=n;i++){
			if (i%7==0||String.valueOf(i).contains("7")) 
				flag++;
			}
	System.out.println(flag);
	}
}
