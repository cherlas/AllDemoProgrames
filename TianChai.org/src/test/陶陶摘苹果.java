package test;

import java.util.Scanner;

public class 陶陶摘苹果 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		String[] input=sc.nextLine().split(" ");
		int s=sc.nextInt()+30;
		int count=0;
		for(int i=0;i<input.length;i++)
			if(Integer.parseInt(input[i])<=s)
				count++;
		System.out.println(count);
	}

}
