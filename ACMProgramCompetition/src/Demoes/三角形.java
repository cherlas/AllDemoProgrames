package Demoes;


import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 */
public class 三角形 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        int[] lengths=new int[n];
        for(int i=0;i<n;i++)
            lengths[i]=sc.nextInt();

        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                for(int k=j+1;k<n;k++){
                    int len=lengths[i]+lengths[j]+lengths[k];
                    int ma=Math.max(lengths[i],Math.max(lengths[j],lengths[k]));
                    int rest=len-ma;
                    if(ma<rest)
                        ans=Math.max(len,ans);
                }
        System.out.println(ans);
    }
}
