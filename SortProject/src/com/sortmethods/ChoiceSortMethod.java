package com.sortmethods;

public class ChoiceSortMethod {
	int[] data={9,7,5,3,4,6};
	public static void main(String[] args) {
		ChoiceSortMethod sortMethod=new ChoiceSortMethod();
		System.out.print("原始数据为： ");
		sortMethod.showData();
		sortMethod.sortData();

	}
	
	public void showData(){
		
	}
	
	public void sortData(){
		for(int i=0;i<data.length;i++){
			for(int j=i+1;j<data.length;j++){
				if(data[i]>data[j]){
					
				}
			}
		}
	}

}
