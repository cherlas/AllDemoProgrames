package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/1.
 */
public class POJ_3061_Subsequence {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int caseNum=sc.nextInt();
        for(int k=0;k<caseNum;k++){
            int n=sc.nextInt();
            int s=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            int res=n+1,sum=0,start=0,end=0;
            for(;;){
                while(end<n&& sum<s) sum+=a[end++];
                if(sum<s) break;
                res=Math.min(res,end-start);
                sum-=a[start++];
            }
            if (res>n) res=0;
            System.out.println(res);
        }
    }
}
