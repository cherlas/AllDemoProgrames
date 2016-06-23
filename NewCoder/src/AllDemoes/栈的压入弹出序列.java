package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 */
public class 栈的压入弹出序列 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] pushA=new int[n];
        int[] popA=new int[n];
        for(int i=0;i<n;i++)
            pushA[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            popA[i]=sc.nextInt();
        IsPopOrder(pushA,popA);

    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int len1=pushA.length;
        int len2=popA.length;
        if(len2!=len1) return false;
        if(len1==0) return false;
        if (len1==1&&pushA[0]==popA[0]) return true;
        int[] temp=new int[len1];
        int push=0,pop=0;
        boolean[] book=new boolean[len1];
        for(int i=0;i<len1;i++)
            book[i]=false;
        while(pop!=len2-1){
            while(push<len1-1&&pushA[push]!=popA[pop]){
                if(!book[push]){
                temp[push]=pushA[push];
                }
                push++;
            }
            if(push<len1)
            book[push]=true;
            pop++;
            int tmp=push;
            while(push>=0&&book[push]) push--;
            while((push>=0&&pop<len1&&temp[push]==popA[pop])){
                if(!book[push])
                    pop++;
                    push--;
                while(push>=0&&book[push]) push--;
            }
            if(push==-1) return true;
            push=tmp;
        }
        return false;
    }
}
