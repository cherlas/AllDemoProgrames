package com.sortmethods;

public class NewBubbleMethod {
	int data[]={4,6,2,7,8,9};
	public static void main(String[] args){
		NewBubbleMethod bubbleMethod=new NewBubbleMethod();
		System.out.println("改良的冒泡排序法");
		System.out.print("原始数据为：");
		bubbleMethod.showData();
		bubbleMethod.sortData();
	}
	
	public void showData(){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
		System.out.println();
	}
	
	public void sortData(){
		int i,j,tmp,flag;
		for(i=data.length-1;i>=0;i--){
			flag=0;
			for (j = 0; j < i; j++) {
				if (data[j]>data[j+1]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
					flag++;
				}
			}
			if (flag==0) {
				break;
			}
			
			System.out.print("第"+(6-i)+"次比较后的结果是：");
			showData();
		}
		
		System.out.print("排序结果是: ");
		showData();
	}
}
