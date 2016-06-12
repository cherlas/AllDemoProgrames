package succeed;

import java.util.*;
public class A_B_C{
    private static Scanner sc;
    public static void main(String[] args){
        sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int sum=0;
        for(int i=0;i<input.length;i++){
            sum+=Integer.parseInt(input[i]);
    }
        System.out.println(sum);
    }
}