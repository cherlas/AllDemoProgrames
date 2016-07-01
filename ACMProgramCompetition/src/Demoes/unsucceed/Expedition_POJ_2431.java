package Demoes.unsucceed;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 */
public class Expedition_POJ_2431 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+1];
        int[] b=new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        int l=sc.nextInt();
        int p=sc.nextInt();
        a[n]=l;
        b[n]=0;
        n++;
        Queue<Integer> queue=new PriorityQueue<Integer>();
        int ans=0,pos=0,tank=p;//需要加油的次数,当前位置,油箱中剩余的油量
        for(int i=0;i<n;i++){
            int dis=a[i]-pos;//到下一加油站的距离
            while (tank-dis<0){
                if(queue.isEmpty()){
                    System.out.println(-1);
                    return;
                }
                int[] tmp=new int[queue.size()];
                System.out.println("tmpsize="+tmp.length);
                for(int j=0;j<=queue.size();j++){
                    tmp[j]=queue.poll();
                }
                System.out.println("TMP:");
                for(int j=0;j<tmp.length;j++)
                    System.out.print(tmp[j]+"   ");
                System.out.println();
                tank+=tmp[tmp.length-1];
                System.err.println("last= "+tmp[tmp.length-1]);
                queue.clear();
                for(int j=0;j<tmp.length-1;j++)
                    queue.add(tmp[j]);
                Iterator iterator=queue.iterator();
                System.out.println("next:");
                while(iterator.hasNext()){
                    System.out.print(iterator.next()+"  ");
                }
                System.out.println();
                ans++;
            }
            tank-=dis;
            pos=a[i];
            queue.add(b[i]);
            System.out.println("add(bi):");
            Iterator iterator=queue.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next()+"  ");
            }System.out.println();
            System.out.println("queuesize="+queue.size());
            System.out.println();
        }
        System.out.println(ans);
    }
}
