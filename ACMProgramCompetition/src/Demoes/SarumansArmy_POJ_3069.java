package Demoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 */
public class SarumansArmy_POJ_3069 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> res=new ArrayList<Integer>();
        while (true){
            int R=sc.nextInt();
            int n=sc.nextInt();
            if(R==-1&&n==-1) break;
            int[] x=new int[n];
            for(int i=0;i<n;i++)
                x[i]=sc.nextInt();
            Arrays.sort(x);
            int i=0,ans=0;
            while(i<n){
                int s=x[i++];
                while(i<n&&x[i]<=s+R) i++;
                int p=x[i-1];
                while (i<n&&x[i]<=p+R) i++;
                ans++;
            }
            res.add(ans);
        }
        for(Integer i:res)
            System.out.println(i);
    }
}
