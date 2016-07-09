package AllDemoes.Important;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yogurt on 16/7/9.
 4
 1 4
 1 3
 1 5
 2 1
 */
public class 进程调度算法 {
    private static class Work implements Comparable{
        int startTime;
        int spendTime;
        public Work(int startTime,int spendTime){
            this.spendTime=spendTime;
            this.startTime=startTime;
        }

        @Override
        public int compareTo(Object o) {
            Work work=(Work)o;
            if (this.startTime>work.startTime) return 1;
            else if (this.startTime==work.startTime)
                if (this.spendTime>work.spendTime) return 1;
                else  return -1;
            else return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Set<Work> works=new TreeSet<>();
        while (sc.hasNext()){
            int n=sc.nextInt();
           // int count=0;
            for (int i=0;i<n;i++){
                works.add(new Work(sc.nextInt(),sc.nextInt()));
                //count+=2;System.out.println(count);
            }

            Iterator iterator=works.iterator();
            int currentTime=0,waitTime=0;
            while (iterator.hasNext()){
                Work work= (Work) iterator.next();
                if (currentTime<=work.startTime){
                    currentTime=work.startTime+work.spendTime;
                }else {
                    waitTime+=currentTime-work.startTime;
                    currentTime+=work.spendTime;
                }
            }
            System.out.printf("%.4f",(float)waitTime/n);
        }
    }
}
