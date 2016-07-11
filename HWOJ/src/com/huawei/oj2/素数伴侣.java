package com.huawei.oj2;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/11.
 */
public class 素数伴侣 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n];
        for(int i=0;i<n;i++)
            data[i]=sc.nextInt();
        int[] d=new int[n];
        for (int i=1;i<n;i++){
            for (int j=i+1;j<n;j++){
               int cnt=isPrime(data[i-1]+data[j-1])? d[i-1]+d[j-1]-d[j]+1 : d[i-1];
                d[i]=Math.max(cnt,d[i]);
            }
        }
        System.out.println(d[n-2]);
    }

    private static boolean isPrime(int n) {
        if (n<=1) return false;
        for (int i=2;i*i<=n;i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
