package com.huawei.oj3;
import java.util.Scanner;

public class YangHuiTriangle {

	private static Scanner sc;
	private static int[][] s;
	private static int n;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		n=sc.nextInt();
		s=new int[n][2*n+1];
		fillMatrix();
	}

	
	private static void fillMatrix() {
		for(int i=0;i<n;i++)
			for(int j=0;j<2*n-1;j++){
				s[i][j]=0;
			}
		
		s[0][n-1]=1;
		s[n-1][0]=s[n-1][n*2-2]=1;
		for(int i=1;i<n;i++)
			for(int j=1;j<n*2-2;j++){
				s[i][j]=s[i-1][j]+s[i-1][j-1]+s[i-1][j+1];
			}
		int flag=0,k = 0;
		for(int i=0;i<2*n-1;i++){
			if(s[n-1][i]%2==0){
				flag++;
				k=i+1;
				break;
			}		
		}
		
		if (flag==0) {
			System.out.println(-1);
		}else {
			System.out.println(k);
		}
	}
}
