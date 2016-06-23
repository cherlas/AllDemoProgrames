package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 不用加减乘除做加法 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(Add(a,b));
    }

    public static int Add(int num1,int num2) {
        int sum;
        do {
            sum=num1^num2;
            num2=(num1&num2)<<1;
            num1=sum;
        }while (num2!=0);
        return  sum;
    }
}
