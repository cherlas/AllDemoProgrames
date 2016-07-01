package AllDemoes.Important;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 抛小球 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        System.out.println((int)(calcDistance(a+b+c+d)));
    }
    public static double calcDistance(int distance){
        return 3*distance;
    }
}
