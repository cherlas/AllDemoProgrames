package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 进制转换{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        System.out.println(Integer.parseInt(input.substring(2),16));
    }
}