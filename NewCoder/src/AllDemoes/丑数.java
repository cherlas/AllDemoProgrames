package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 丑数 {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(GetUglyNumber_Solution(n));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index<=0) return 0;
        if(index==1) return 1;
        int res=1;
        while(index>0){
            if(isUglyNumber(res))index--;
            if(index==0) break;
            res++;
        }
        return res;
    }

    public static boolean isUglyNumber(int n){
        if(n>=1&&n<=6) return true;
        while(n!=1){
            int i=2;
            while(n%i!=0) i++;
            if(i!=2&&i!=3&&i!=5) return false;
            n=n/i;
        }
        return true;
    }
}
