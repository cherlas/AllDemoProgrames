package Demoes.unsucceed;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/1.
 */
public class POJ_3276_Face_The_Right_Way {
    private static int[] f,dir;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        dir=new int[n+1];
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            if (s.equals("F")) dir[i]=0;
            else dir[i]=1;
        }
        f=new int[n+1];//区间[i,i+k-1]是否翻转
        int K=1,M=n;
        for (int k=1;k<=n;k++){
            int m=calc(k,n);
            if(m>=0&&m<M){
                M=m;
                K=k;
            }
        }
        System.out.println(K+" "+M);
    }

    private static int calc(int k,int n) {
        for(int i=0;i<=n;i++) f[i]=0;
        int res=0,sum=0;
        for(int i=0;i+k<=n;i++){
            if ((sum+dir[i])%2!=0){
                res++;
                f[i]=1;
            }
            sum+=f[i];
            if(i-k+1>=0) sum-=f[i-k+1];
        }
        for(int i=n-k+1;i<n;i++){
            if(sum+dir[i]%2!=0)
                return -1;
            if(i-k+1>=0) sum-=f[i-k+1];
        }
        return res;
    }
}
