package com.huawei.oj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcrossSort {
	static int[] num;
	public static void main(String[] args) {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str = null;

		try {
			str=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] num1=str.split(" ");
		num=new int[num1.length];
		for (int i = 0; i < num1.length; i++) {
			num[i]=Integer.parseInt(num1[i]);
		}
		AcrossSort acrossSort=new AcrossSort();
		Long time1=System.currentTimeMillis();
		acrossSort.sortAscend(0,num.length-2);
		acrossSort.sortDescend(1,num.length-1);
		acrossSort.show();
		
		long time2=System.currentTimeMillis();
		
		long spendTime=time2-time1;
		System.out.println(spendTime);
		}
	
	public void sortAscend(int low,int high){  //奇数位升序
		/*
		 * 快速排序
		 */
		int l=low;
		int h=high;
		int povit=num[low];
		while(l!=h){
			while(l<h&&num[h]>=povit)
				h-=2;
			if(l<h){
				int tmp=num[h];
				num[h]=num[l];
				num[l]=tmp;
				l+=2;	
			}
			
			while(l<h&&num[l]<=povit)
				l+=2;
			if (l<h) {
				int tmp=num[h];
				num[h]=num[l];
				num[l]=tmp;
				h-=2;
			}
			if (l>low)  	sortAscend(low, l-2);
			if(h<high)		sortAscend(l+2, high);
		}
		
	}
	
	public void sortDescend(int low,int high){  //偶数位下降
		int l=low;
		int h=high;
		int povit=num[low];
		while(l!=h){
			while(l<h&&num[h]<=povit)
				h-=2;
			if (l<h) {
				int tmp=num[l];
				num[l]=num[h];
				num[h]=tmp;
				l+=2;
			}
			
			while(l<h&&num[l]>=povit)
				l+=2;
			if(l<h){
				int tmp=num[l];
				num[l]=num[h];
				num[h]=tmp;
				h-=2;
			}
			if (l>low)  sortDescend(low, l-2);
			if (h<high) sortDescend(l+2,high);				
			}
	}
	
	public void show(){
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
	}
}
