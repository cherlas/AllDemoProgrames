package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/24/16.
 in:
 4
 2 3
 1 2
 3 4
 2 2
 5
 out:
 */
public class 背包问题0_1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] w=new int[n];
        int[] v=new int[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }
        int W=sc.nextInt();

        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<n;i++)
            dp[0][i]=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<=W;j++){
                if(j<w[i])
                    dp[i+1][j]=dp[i][j];
                else
                    dp[i+1][j]=Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
            }
        System.out.println(dp[n][W]);
    }
}
