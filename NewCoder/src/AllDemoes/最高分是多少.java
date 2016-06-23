package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 */
public class 最高分是多少 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] score=new int[N];
        for(int i=0;i<N;i++)
            score[i]=sc.nextInt();
        for(int i=0;i<M;i++){
            String str=sc.next();
            int id1=sc.nextInt();
            int id2=sc.nextInt();
            if(str.equals("Q")){
                if(id1>id2){
                    int t=id1;
                    id1=id2;
                    id2=t;
                }
                int max=score[id1-1];
                for(int j=id1;j<id2;j++)
                    if(max<score[j])
                        max=score[j];
                System.out.println(max);
            }else if(str.equals("U")){
                score[id1-1]=id2;
            }
        }
    }
}
