package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 字符串中最后一个单词的长度 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        System.out.println(input[input.length-1].length());
    }
}
