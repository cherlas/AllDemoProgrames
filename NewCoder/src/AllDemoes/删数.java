package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 删数 {
    static boolean[] book;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        book=new boolean[n];
        for(int i=0;i<n;i++)
            book[i] = false;
        System.out.println(originalIndex(n));
    }

    public static int originalIndex(int n){
        if(n==0||n==1||n==2) return n-1;
        int sum=0;
        int originalIndex=0;
        int i=0;
        while(sum<n){
            if(originalIndex==n-1&&book[n-1]) originalIndex=0;

            while(i<2){

                if (!book[originalIndex]) i++;
                originalIndex++;
                if(originalIndex==n||(originalIndex==n-1&&book[n-1])) {
                    originalIndex=0;
                    while(book[originalIndex])
                        originalIndex++;
                }
            }
            while (book[originalIndex]) {
                originalIndex++;
                if(originalIndex==n)
                    originalIndex=0;
            }
            book[originalIndex]=true;
            sum++;
            i=0;
        }
        return originalIndex;
    }

}
