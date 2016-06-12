package com.huawei.oj1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 矩阵乘法计算量估计 {
	private static Scanner sc;
	private static Map<String, Matrix> map=new HashMap<>();
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		char c='A';
		for(int i=0;i<num;i++)
			map.put(((char)(c+i))+"", new Matrix(sc.nextInt(), sc.nextInt()));
		StringBuffer order=new StringBuffer(sc.next());
		int a1=order.lastIndexOf("(");
		int a2=order.indexOf(")",a1);
		int count=0,flag=num;
		while(a1!=-1){
			String sub=order.substring(a1+1,a2);
			String str=sub.charAt(0)+"";
			Matrix matrix1=map.get(str);
			int firstRow=matrix1.row,lastCol=0;
			for(int i=1;i<sub.length();i++){
				str=sub.charAt(i)+"";
				Matrix matrix2=map.get(str);
				count+=firstRow*matrix2.row*matrix2.col;
				if (i==sub.length()-1) {
					lastCol=matrix2.col;
				}
			}
			order.replace(a1, a2+1, ((char)(c+flag))+"");
			map.put(((char)(c+flag))+"", new Matrix(firstRow, lastCol));
			flag++;
			a1=order.lastIndexOf("(");
			a2=order.indexOf(")",a1);
		}
		String str=order.charAt(0)+"";
		Matrix matrix1=map.get(str);
		int firstRow=matrix1.row,lastCol=0;
		for(int i=1;i<order.length();i++){
			str=order.charAt(i)+"";
			Matrix matrix2=map.get(str);
			count+=firstRow*matrix2.row*matrix2.col;
			if (i==order.length()-1) {
				lastCol=matrix2.col;
			}
		}
		System.out.println(count);
	}

	
	static class Matrix{
		int row;//行数
		int col;//列数
		public Matrix(int row, int col) {
			this.row=row;
			this.col=col;
		}
	}
}
