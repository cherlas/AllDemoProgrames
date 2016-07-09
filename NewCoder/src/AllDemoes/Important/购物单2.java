package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/9.
 */
public class 购物单2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] weight=new int[m+1][3];
        int[][] val=new int[m+1][3];
        for(int i=0;i<m;i++){
            int c=sc.nextInt();
            int p=sc.nextInt();
            int q=sc.nextInt();
            if (q==0){
                weight[i][q]=c;
                val[i][q]=p*c;
            }else if (weight[q-1][1]==0){
                weight[q-1][1]=c;
                val[q-1][1]=c*p;
            }else {
                weight[q-1][2]=c;
                val[q-1][2]=c*p;
            }
        }

        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for (int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if (j>=weight[i][0]){
                    dp[i][j]=Math.max(dp[i-1][j-weight[i][0]]+val[i][0],dp[i][j]);
                }
                if (j>=weight[i][0]+weight[i][1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i][0]-weight[i][1]]+val[i][0]+val[i][1]);
                }
                if (j>=weight[i][0]+weight[i][2]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i][0]-weight[i][2]]+val[i][0]+val[i][2]);
                }
                if (j>=weight[i][0]+weight[i][1]+weight[i][2]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i][0]-weight[i][1]-weight[i][2]]+val[i][0]+val[i][1]+val[i][2]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
