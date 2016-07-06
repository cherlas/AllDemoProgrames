package AllDemoes;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yogurt on 16/7/6.
 */
public class 明明的随机数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            Set<Integer> set=new TreeSet<>();
            for(int i=0;i<n;i++)
                set.add(sc.nextInt());
            Iterator iterator=set.iterator();
            while(iterator.hasNext())
                System.out.println(iterator.next());
        }
    }
}
