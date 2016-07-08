package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/7.
 */
public class 最长回文子序列_最长子序列 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int n=sc.nextInt();
        System.out.println(getLongestPalindrome(A,n));
    }

    private static int getLongestPalindrome(String A, int n) {
        StringBuffer sb=new StringBuffer();
        for(int i=n-1;i>=0;i--)
            sb.append(A.charAt(i));
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sb.charAt(i)==A.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        for (int i=0;i<=n;i++){
            for (int j=0;j<=n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][n];
    }
}
