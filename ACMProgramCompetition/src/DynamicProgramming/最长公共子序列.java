package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/24/16.
 */
public class 最长公共子序列 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String s=sc.next();
        String t=sc.next();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(s.charAt(i)==t.charAt(j))
                    dp[i+1][j+1]=dp[i][j]+1;
                else
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        System.out.println(dp[n][m]);
    }
}
