package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/8.
 */
public class 公共子串 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println(getLongestCommonSubSequeues(str1.length()>str2.length()? str1:str2,str1.length()<str2.length()?str1:str2));
    }
    private static String getLongestCommonSubSequeues(String A, String B) {
        int n=A.length();
        int m=B.length();
        int len=0;
        StringBuffer[][] dp=new StringBuffer[n+1][n+1];
        String lcs="";
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if (i==0||j==0)
                    dp[i][j]=new StringBuffer("");
                else if (A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1].append(A.charAt(i-1));
                    if (dp[i][j].length()>len){
                        lcs=dp[i][j].toString();
                        len= dp[i][j].length();
                    }
//                    else if (dp[i][j].length()==len){
//                        lcs=lcs+","+dp[i][j];
//                    }
                }
                else
                    dp[i][j]=new StringBuffer("");
            }
        }
        return lcs;
    }
}
