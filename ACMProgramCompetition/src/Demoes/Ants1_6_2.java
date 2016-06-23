package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 * in:
 10
 3
 2 6 7
 out:
 max=8
 min=4
 */
public class Ants1_6_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int L=sc.nextInt();
        int n=sc.nextInt();
        int[] lengthToLeft=new int[n];
        for(int i=0;i<n;i++)
            lengthToLeft[i]=sc.nextInt();
        int max=0,min=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,Math.max(lengthToLeft[i],L-lengthToLeft[i]));
            min=Math.max(min,Math.min(lengthToLeft[i],L-lengthToLeft[i]));
        }
        System.out.println("max="+max);
        System.out.println("min="+min);
    }
}
