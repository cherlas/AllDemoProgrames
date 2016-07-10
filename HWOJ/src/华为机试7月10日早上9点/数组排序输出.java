package 华为机试7月10日早上9点;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 数组排序输出 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n];
        assert n!=0;
        for (int i=0;i<n;i++)
            data[i]=sc.nextInt();
        Arrays.sort(data);
        for (int i=0;i<n;i++)
            System.out.print(data[i]+" ");
        System.out.println();
        System.out.print(data[0]);
        for (int i=1;i<n-1;i++){
            if (data[i]-data[i-1]==1) continue;
            System.out.print(" "+data[i-1]+" "+data[i]);
        }
        System.out.println(" "+data[n-1]);
    }
}
