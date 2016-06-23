package 乐视实习;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/22/16.
 */
public class 质数因子 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        System.out.println(getResult(n));
    }

    private static String getResult(long n) {
        String res="";
        while(n!=1){
            int i=2;
            while (n%i!=0) i++;
            res+=i+" ";
            n=n/i;
        }
        return res;
    }
}
