package Demoes;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/2.
 */
public class POJ_3684_PhysicsExperiment {
    private static int C,N,H,R,T;
    private static double[] res;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        C=sc.nextInt();
        for(int i=0;i<C;i++){
            N=sc.nextInt();
            H=sc.nextInt();
            R=sc.nextInt();
            T=sc.nextInt();
            res=new double[N];
            for(int j=0;j<N;j++)
                res[j]=calc(T-j);
            Arrays.sort(res);
            for(int j=0;j<N;j++) {
                System.out.printf("%.2f", res[j]+2*R*j/100.0);
                if (j != N - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static double calc(int t) {
        if(t<0) return H;
        double t1=Math.sqrt(2*H/10.0);
        int k= (int)(t/t1);
        if(k%2==0){
            double d=t-k*t1;
            return H-10.0*d*d/2;
        }else {
            double d=k*t1+t1-t;
            return H-10.0*d*d/2;
        }
    }
}
