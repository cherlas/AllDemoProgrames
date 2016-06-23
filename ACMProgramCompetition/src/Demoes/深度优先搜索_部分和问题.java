package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/23/16.
 */
public class 深度优先搜索_部分和问题 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] input=new int[n];
        for(int i=0;i<n;i++)
            input[i]=sc.nextInt();
        int k=sc.nextInt();
        int sum=0;
        System.out.println(dfs(0,0,k,n,input));
    }

    private static boolean dfs(int i, int sum,int k,int n,int[] input) {
        if(i==n) return sum==k;
        if (dfs(i+1,sum,k,n,input)) return true;
        if (dfs(i+1,sum+input[i],k,n,input)) return true;
        return false;
    }
}
