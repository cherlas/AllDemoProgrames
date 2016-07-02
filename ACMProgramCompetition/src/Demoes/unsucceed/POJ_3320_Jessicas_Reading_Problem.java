package Demoes.unsucceed;



/**
 * Created by Yogurt on 16/7/1.
 #include <cstdlib>
 #include <cstdio>
 #include <set>
 #include <map>

 const int NMAX = 1000000;
 int P;
 int a[NMAX];

 int main()
 {
 while(scanf("%d", &P) != EOF)
 {
 std::set<int> point_num;
 for(int i = 0; i < P; i++)
 scanf("%d", &a[i]), point_num.insert(a[i]);
 int n = point_num.size();

 std::map<int, int> count;
 int res = P;
 int t = 0, s = 0, num = 0;
 while(true)
 {
 while(t < P && num <n)
 if(count[a[t++]] ++ == 0)
 num ++;

 if(num < n)
 break;

 res = std::min(res, t-s);
 if(--count[a[s++]] == 0)
 -- num;
 }
 printf("%d\n", res);
 }
 return 0;
 }
 */
import java.util.*;
public class POJ_3320_Jessicas_Reading_Problem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int[] a=new int[p];
        Set<Integer> all=new HashSet<Integer>();
        int max=0;
        for(int i=0;i<p;i++) {
            a[i] = sc.nextInt();
            if (a[i]>max) max=a[i];
            all.add(a[i]);
        }
        int n=all.size();
        int[] count=new int[max+1];
        for(int i=0;i<=max;i++)
            count[i]=0;
        int res=p,start=0,end=0,num=0;
        for(;;){
            while(end<p&&num<n)
                if(count[a[end++]]++==0)
                    num++;
            if(num<n) break;
            res=Math.min(res,end-start);
            if(--count[a[start++]]==0)
                num--;
        }
        System.out.println(res);
    }
}
