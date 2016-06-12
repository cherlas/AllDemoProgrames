package com.huawei.oj1;
import java.io.*;
class 快速排序{
    static int num,flag=0;
    static int[] arr;
	private static String str;  
    public static void main(String[] args){
    	InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try{
        while((br.readLine()!=null)){
       
        num=Integer.parseInt(str=br.readLine());
            if(num>1000){
            	System.out.println("Input Error");
            	System.exit(0);
            }
            arr=new int[num];
        outer:
            for(int i=0;i<num;i++){
        	int num1=Integer.parseInt(str=br.readLine());
            if(num1<1||num1>1000){
            	System.out.println("Input Error");
            	System.exit(0);
            }
            for(int j=0;j<flag;j++){
                if(arr[j]==num1){
                	continue outer;
                }
                
            }
            arr[flag]=num1;
            flag++;
        }
        sort(0,flag-1);
        for(int i=0;i<flag;i++){
    		System.out.println(arr[i]);
    	}
            
        }
        
    }catch(Exception e){
       // System.out.println("Input Error");
        }
    }
    static void sort(int low,int high){
        if(low>=0&&low<flag&&high>=0&&high<flag&&low<high){
        	int l=low,h=high;
            int pov=arr[low];
            while(l<h){
            
                while(l<h&&arr[h]>=pov)
                    h--;
                if(l<h){
                	int tmp=arr[l];
                    arr[l]=arr[h];
                    arr[h]=tmp;   
                    l++;
                } 
                while(l<h&&arr[l]<=pov)
                    l++;
                if(l<h){
                	int tmp=arr[l];
                    arr[l]=arr[h];
                    arr[h]=tmp;   
                    h--;
                } 
            }
            sort(low,h-1);
            sort(h+1,high);
        }
        
    }
}

