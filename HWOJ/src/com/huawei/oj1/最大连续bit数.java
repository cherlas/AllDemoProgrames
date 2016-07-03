package com.huawei.oj1;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/3.
 */
public class 最大连续bit数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        byte num=sc.nextByte();
        String str=Integer.toBinaryString(num);
        int numOne=0,max=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c=='0')
                numOne=0;
            else
                numOne++;
            max=Math.max(numOne,max);
        }
        System.out.println(max);
    }
}
