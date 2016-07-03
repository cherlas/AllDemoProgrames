package com.huawei.unsuccessed;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/3.
 */
public class 笔画 {
    private static int[][] data,tmp;
    private static int n,step,startX,startY;
    private static boolean succeed;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        data=new int[n][n];
        tmp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                data[i][j]=0;
        for(int i=0;i<n;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            data[a][b]=1;
            data[b][a]=1;
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++)
                sum+=data[i][j];
            if (sum%2!=0) {
                System.out.println("false");
                return;
            }
        }
        for(int i=0;i<n&&!succeed;i++){
                succeed=false;
                step=0;
                startX=i;

                for(int a=0;a<n;a++)
                    for(int b=0;b<n;b++)
                        tmp[a][b]=data[a][b];

                dfs(i);
        }
        if (succeed) System.out.println("true");
        else System.out.println("false");
    }

    private static void dfs(int x) {
        if (succeed) return;
        if(step>n&&x==startX){
            succeed=true;
            return;
        }
        for(int i=0;i<n;i++) {
            if (tmp[x][i] == 1) {
                step++;
                tmp[x][i]=tmp[i][x]=0;
                dfs(i);
                tmp[x][i]=1;
                tmp[i][x]=1;
            }
        }
        return;
    }
}
