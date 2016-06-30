package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 */
public class BestCowLine_POJ_3617 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        sc.nextLine();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<N;i++)
            str.append(sc.nextLine());
        StringBuilder res=new StringBuilder();
        int a=0,b=N-1;
        while (a<=b){
            boolean left=false;
            for (int i=0;a+i<b;i++){
                if(str.charAt(a+i)<str.charAt(b-i)){
                    left=true;
                    break;
                }else if(str.charAt(a+i)>str.charAt(b-i)){
                    left=false;
                    break;
                }
            }
            if (left) res.append(str.charAt(a++));
            else res.append(str.charAt(b--));
        }
        for(int i=0;i<res.length();i++){
            if(i>0&&i%80==0)
                System.out.println();
            System.out.print(res.charAt(i));
        }
        System.out.println();
    }
}
