package Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Yogurt on 6/23/16.
 5
 1 2 4 6 8
 3 5 7 9 10

 3
 */
public class 贪心算法2_2_2区间问题 {
    private static class Time implements Comparable{
        int endTime;
        int startTime;
        public Time(int endTime,int startTime){
            this.endTime=endTime;
            this.startTime=startTime;
        }

        @Override
        public int compareTo(Object o) {
            Time t=(Time)o;
            if(this.endTime>=t.endTime) return 1;
            return 0;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] s=new int[n];
        int[] t=new int[n];
        for(int i=0;i<n;i++)
            s[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            t[i]=sc.nextInt();
        Time[] times=new Time[n];
        for(int i=0;i<n;i++)
            times[i]=new Time(t[i],s[i]);

        Arrays.sort(times);//按结束时间先后顺序排序
        int a=0,ans=0;
        for(int i=0;i<n;i++)
            if (a<times[i].startTime){ //当前作业的结束时间小于下一个作业的开始时间
                ans++;
                a=times[i].endTime;
            }

        System.out.println(ans);
    }
}
