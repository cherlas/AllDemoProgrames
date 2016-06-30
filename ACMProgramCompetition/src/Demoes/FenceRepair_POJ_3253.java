package Demoes;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 */
public class FenceRepair_POJ_3253 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Long> queue=new PriorityQueue<Long>();
        for(int i=0;i<n;i++)
            queue.add(sc.nextLong());
        long ans=0;

        while (queue.size()>1){
            long l1=queue.poll();
            long l2=queue.poll();
            System.out.println(l1+"  "+l2);
            ans+=l1+l2;
            queue.add(l1+l2);
        }
        System.out.println(ans);
    }
}
