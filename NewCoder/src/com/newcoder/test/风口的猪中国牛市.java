package com.newcoder.test;

public class 风口的猪中国牛市 {

	public static void main(String[] args) {
		
//		int[] prices=new int[]{3,8,5,1,7,8};
		int[] prices=new int[]{1,10,2,12};
		System.out.println("max:"+calculateMax(prices));
	}
	public static int calculateMax(int[] prices) {
        int max1,max2,max=0;
		for(int i=0;i<prices.length;i++){
			max1=0;
			int firstEnd = 0;
			for(int j=i+1;j<prices.length;j++){
				if(prices[j]-prices[i]>max1){
					max1=prices[j]-prices[i];
					firstEnd=j;
				}
			}
			max2=0;
			for(int j=firstEnd+1;j<prices.length;j++){
				for(int k=j+1;k<prices.length;k++){
					if(prices[k]-prices[j]>max2){
						max2=prices[k]-prices[j];
					}
				}
			}			
			if(max1+max2>max) max=max1+max2; 
			System.err.println("max1: "+max1+"  max2:"+max2+"  max:"+max);
		}
       return max;
        
    }
}
