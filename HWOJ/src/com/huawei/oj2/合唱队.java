package com.huawei.oj2;

import java.util.Arrays;  
import java.util.Scanner;  
  
public class 合唱队 {

    private static int[] dpI;//上升子序列
    private static int[] dpD;//下降子序列

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] height=new int[n];
        int[] sortedHeight=new int[n];
        for(int i=0;i<n;i++){
            height[i]=sc.nextInt();
            sortedHeight[i]=height[i];
        }
        Arrays.sort(sortedHeight);
        dpI=new int[n+1];
        dpD=new int[n+1];
        getLongestIncreaingSuquence(n,height);
        getLongestDecreaingSuquence(n,height);

        int index=0,max=0;
        for (int i=0;i<n;i++){
            if (max<dpI[i]+dpD[i]){
                max=dpD[i]+dpI[i];
                index=i;
            }
        }
        System.out.println(n-dpI[index]-dpD[index]+1);
    }

    private static void getLongestDecreaingSuquence(int n,int[] height) {
            for (int i=n-1;i>=0;i--){
                dpD[i]=1;
                for (int j=n-1;j>i;j--){
                    if (height[j]<height[i])
                        dpD[i]=Math.max(dpD[i],dpD[j]+1);
                }
            }
    }

    private static void getLongestIncreaingSuquence(int n,int[] height) {//上升子序列

        for (int i=0;i<n;i++){
            dpI[i]=1;
            for (int j=0;j<i;j++){
                if (height[i]>height[j])
                    dpI[i]=Math.max(dpI[i],dpI[j]+1);
            }
        }
    }
}