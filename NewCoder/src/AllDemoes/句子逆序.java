package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 句子逆序 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        for(int i=input.length-1;i>=0;i--){
            System.out.print(input[i]);
            if(i!=0) System.out.print(" ");
        }
        System.out.println();
    }
}
