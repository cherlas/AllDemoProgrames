package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 空瓶换饮料 {
	
	public static int[] num;
	public static int[] emptyBottle = new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException{
		InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int bottle,flag=0;
        
        try{
        while((bottle=Integer.parseInt(br.readLine()))!=0){
            if(bottle<=0||bottle>100){
             System.out.println("Input Error");
             System.exit(0);
            }
            emptyBottle[flag]=bottle;
            flag++;
        }
        }catch(Exception e){
        	e.printStackTrace();
        }
        num=new int[flag];
        for(int i=0;i<flag;i++){
        	find(emptyBottle[i],i);
        }
        for(int i=0;i<num.length;i++){
        	System.out.println(num[i]);
        }
	}
	
	public static void find(int empty,int number){
    	int sumBottle=0;
        int tmp1=empty/3,tmp2=empty%3;
        
        sumBottle+=tmp1;
        while(((tmp1+tmp2)/3)!=0){
        	tmp1=(tmp1+tmp2)/3;
            sumBottle+=tmp1;
            tmp2=(tmp1+tmp2)%3;
        }
        if((tmp1+tmp2)==2){
       		sumBottle++;
        }            
        num[number]=sumBottle;
    }    
}
