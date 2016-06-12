package com.huawei.unsuccessed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.crypto.Data;


public class 求最大多边形 {
	static String[] inputData;
	static int[][] coordinate;
	static double[] kk;
	int flag=0;
	private static int num;
	private static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str=br.readLine();
		
		inputData=str.split(";");
		try {
			num=Integer.parseInt(inputData[0]);
		} catch (Exception e1) {
			System.out.println("输入的第一个数必须是正整数");
		}
		
		if (num>65535) {
			System.out.println("坐标个数必须小于65535");
			System.exit(0);
		}
		isVisited=new boolean[num];
		coordinate=new int[num][2];
		for(int i=0;i<num;i++){
			isVisited[i]=false;
			String[] string=new String[2];
			string=inputData[i+1].split(",");
			try {
				coordinate[i][0]=Integer.parseInt(string[0]);
				coordinate[i][1]=Integer.parseInt(string[1]);
			} catch (Exception e) {
				System.out.println("输入坐标必须是整数");
				System.exit(0);
			}
			if (coordinate[i][0]<-1000||coordinate[i][0]>1000||coordinate[i][1]<-1000||coordinate[i][1]>1000) {
				System.out.println("坐标大小必须在[-1000,1000]之间");
				System.exit(0);
			}
		}
		
		
		求最大多边形 mpf=new 求最大多边形();
		mpf.sort();
		for (int i = 0; i < num; i++) {
			System.out.println(coordinate[i][0]+"  "+coordinate[i][1]);
		}
		mpf.search();
		
	}
	public void sort(){  //按横坐标升序排列
		for(int i=0;i<num;i++){
			for(int j=i;j<num;j++){
				if(coordinate[i][0]>coordinate[j][0])
					swap(i,j);
			}			
		}
	}
	
	public void search(){
		
		isVisited[0]=true;
		int x=coordinate[0][0];
		int y=coordinate[0][1];
		for(int i=1;i<num;i++){
			if (coordinate[i][0]>x&&coordinate[i][1]>y&&isVisited[i]) {
				isVisited[i]=true;
				kk[flag]=(double)(coordinate[i][0]-x)/(double)(coordinate[i][1]-y);
				flag++;
			}
		}
		
	}
	
	public void swap(int i,int j){
		int tmp;
		tmp=coordinate[i][0];
		coordinate[i][0]=coordinate[j][0];
		coordinate[j][0]=tmp;
		tmp=coordinate[i][1];
		coordinate[i][1]=coordinate[j][1];
		coordinate[j][1]=tmp;
	}
}
