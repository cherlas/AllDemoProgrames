package 华为机试7月10日下午1点;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 求平方根 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
//        double err=1e15;
//        int t=x;
//        while (Math.abs(t-x/t)>t*err)
//            t=(x/t+t)/2;
        System.out.println((int)Math.sqrt(x));
    }
}
