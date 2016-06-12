package com.huawei.oj3;
import java.util.Scanner;

public class MatrixMultiplication {
	private static Scanner sc;
	private static int[][] array1,array2;
	private static int x,y,z;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		x=sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		array1=new int[x][y];
		array2=new int[y][z];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				array1[i][j]=sc.nextInt();
			}
		}	
		for(int i=0;i<y;i++){
			for(int j=0;j<z;j++){
				array2[i][j]=sc.nextInt();
			}
		}
		matrix_multiply(array1,array2);
	}
	private static void matrix_multiply(int [][] arr1,int[][] arr2){
		int[][] result=new int[x][z];
		for(int i=0;i<x;i++){
			for(int j=0;j<z;j++){
				for(int k=0;k<y;k++){
					result[i][j]+=arr1[i][k]*arr2[k][j];
				}
			}
		}
		
		for(int i=0;i<x;i++){
			for(int j=0;j<z;j++){
				if(j!=z-1)
				System.out.print(result[i][j]+" ");
				else {
					System.out.print(result[i][j]);
				}
			}
			System.out.println();
		}
	}
}
