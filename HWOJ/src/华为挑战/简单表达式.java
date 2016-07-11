package 华为挑战;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/11.
 */
public class 简单表达式 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(calculate(x));
    }

    private static int calculate(int x) {
        int y;
        if (x<1) return x;
        if (x>=1&&x<10) return 2*x-1;
        return 3*x-11;
    }
}
