package com.huawei.oj3;
import java.io.*;
class Main{
    public static int[] num;
		
    static int bottle,flag=0;
    public static void main(String[] args)
    {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        int[] emptyBottle=new int[10];
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
static void find(int empty,int number){
    	int sumBottle=0;
        int tmp1=empty/3,tmp2=empty%3;
        sumBottle+=tmp1;
        empty=tmp1+tmp2;
        while((empty/3)!=0){
            
            tmp1=(empty)/3;
            sumBottle+=tmp1;
            tmp2=empty%3;
            empty=tmp1+tmp2;
        }
        if(empty==2){
       		sumBottle++;
        }            
        num[number]=sumBottle;
    }    
}