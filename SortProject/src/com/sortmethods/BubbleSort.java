package com.sortmethods;

public class BubbleSort {
	
	public static void main(String[] args){
		int i,j,tmp;
		int[] data={6,5,9,7,2,8};
		
		System.out.println("-----Bubble Sort-----");
		System.out.println("-----Original Data-----");
		for(i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
		System.out.println();
		for(i=data.length-1;i>=0;i--){
			for(j=0;j<i;j++){
				if(data[j]>data[j+1]){
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
				}
			}
			System.out.print("-----第"+(6-i)+"次比较后的结果是：");
			for (j = 0; j < data.length; j++) {
				System.out.print(data[j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("-----排序结果是-----");
		for(i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
	}
	
	
}
