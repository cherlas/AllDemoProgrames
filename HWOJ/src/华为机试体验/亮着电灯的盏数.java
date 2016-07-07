package 华为机试体验;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/7.
 */
public class 亮着电灯的盏数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++)
            if (calFactor(i)%2==1) count++;
        System.out.println(count);
    }

    private static int calFactor(int n) {
        int factors=0;
        for(int i=1;i<=n;i++)
            if(n%i==0) factors++;
        return factors;
    }
}
