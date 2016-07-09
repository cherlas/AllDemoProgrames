package AllDemoes;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/9.
 */
public class 页面调度算法 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            List<Integer> list=new LinkedList<>();
            int count=0;
            for (int i=0;i<m;i++){
                int a=sc.nextInt();
                if (list.size()<n){
                    if (list.contains(a))
                        continue;
                    else {
                        list.add(a);
                        count++;
                    }

                }else if (list.size()==n){
                    if (list.contains(a))
                        continue;
                    else {
                        list.remove(0);
                        list.add(a);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
