package com.huawei.oj1;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/3.
 */
public class 合法IP {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] strs=str.split("\\.");
        if (strs.length!=4) {
            System.out.println("NO");
            System.out.println(111);
            return;
        }
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs[i].length();j++){
                char c=strs[i].charAt(j);
                if (c<'0'||c>'9'){
                    System.out.println("NO");
                    return;
                }
            }
            int ip=Integer.parseInt(strs[i]);
            if (ip<0||ip>255){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
