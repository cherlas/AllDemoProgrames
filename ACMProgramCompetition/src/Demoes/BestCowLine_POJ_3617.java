package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 */
public class BestCowLine_POJ_3617 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder res=new StringBuilder();
        int a=0,b=str.length()-1;
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
        System.out.println(res);
    }
}
