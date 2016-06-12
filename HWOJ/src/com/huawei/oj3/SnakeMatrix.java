package com.huawei.oj3;
import java.util.Scanner;

public class SnakeMatrix {
	private static int n;
	private static int[][] s;
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n=sc.nextInt();
		s=new int[n][n];
		fillMatrix();
		print();
	}
private static void fillMatrix() {
	s[0][0]=1;
	for(int i=1;i<n;i++){
		s[i][0]=s[i-1][0]+i;
		s[0][i]=s[0][i-1]+i+1;
	}
	
	for(int i=1;i<n;i++){
		for(int j=1;j<n-i;j++){
			s[i][j]=s[i][j-1]+j+i+1;
		}
	}
 }

private static void print() {
	for(int i=0;i<n;i++){
		for(int j=0;j<n-i;j++){
			if (j!=n-i-1) {
				System.out.print(s[i][j]+" ");
			}else {
				System.out.print(s[i][j]);
			}
			
		}
		if (i<n-1) {
			System.out.println();
		}
		
	}
}
}
