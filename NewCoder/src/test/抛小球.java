package test;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 抛小球 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //int a=sc.nextInt();
       // int b=sc.nextInt();
        System.out.println(calculateHeight(315+124+3+436));
        System.out.println(calculateHeight(871));
        System.out.println(calculateHeight(19));
        System.out.println(calculateHeight(164));
        System.out.println(calcDistance(315,124,3,436));
    }
    public static int calcDistance(int A, int B, int C, int D) {
        // write code here
        //System.out.println(calculateHeight(A)+ calculateHeight(B)+ calculateHeight(C)+ calculateHeight(D));
        return (int) Math.floor(calculateHeight(A)+ calculateHeight(B)+ calculateHeight(C)+ calculateHeight(D));
    }
    public static double calculateHeight(double n){
        double sum=n;
        while(n!=0){
            sum+=n;
            n/=2;
        }
        return sum;
    }
}
