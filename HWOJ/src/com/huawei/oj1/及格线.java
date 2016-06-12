package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 及格线 {
    static int[] score = new int[10];
	public static void main(String[] args) throws IOException{
		String[] score1;
		
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		String ss;
		ss=br.readLine();
		score1=ss.split(" ");
		for(int i=0;i<10;i++){
			score[i]=Integer.parseInt(score1[i]);
			if (score[i]>100||score[i]<0) {
				System.out.println("输入错误");
				System.exit(0);
			}
		}
		及格线 ps=new 及格线();
		ps.sort();
		System.out.println();
		if (score[0]>=60) {
			System.out.println("60");
		}else {
			System.out.println(score[4]/10*10);
		}
		
	}
	
	public void sort(){
		int tmp;
		for(int i=0;i<10;i++){
			for(int j=i;j<10;j++){
				if (score[i]>score[j]) {
					tmp=score[i];
					score[i]=score[j];
					score[j]=tmp;
				}
			}
		}
	}
	
	
	
}
