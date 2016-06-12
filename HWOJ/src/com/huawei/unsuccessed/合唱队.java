package com.huawei.unsuccessed;

import java.util.Arrays;  
import java.util.Scanner;  
  
class 合唱队 {  
    private static int[] beautifulScore;  
    private static int num;  
    private static String[] datas= null;  
    public static void main(String[] args) {  
        @SuppressWarnings("resource")  
        Scanner sc=new Scanner(System.in);  
        num=sc.nextInt();  
        sc.nextLine();  
        datas=new String[num];  
        for(int i=0;i<num;i++){  
            datas[i]=sc.nextLine();  
        }  
        int[] times=new int[26];  
        beautifulScore=new int[num];  
          
        for(int i=0;i<num;i++){  
            for (int k = 0; k < 26; k++) {  
                times[k]=0;  
            }  
            datas[i].toLowerCase();  
            for(int j=0;j<datas[i].length();j++){  
                times[datas[i].charAt(j)-97]++;  
            }  
            Arrays.sort(times);  
            for(int j=25;j>=0&&times[j]!=0;j--){  
                beautifulScore[i]+=(times[j]*(1+j));  
            }  
        }  
        for (int i = 0; i <num; i++) {  
            System.out.println(beautifulScore[i]);  
        }  
    }   
} 