package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/6.
 */
public class 删数2 {
    private static boolean[] book;
    private static int[] ints;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextInt()){
            int n=sc.nextInt();
            ints=new int[n];
            book=new boolean[n];
            for(int i=0;i<n;i++){
                ints[i]=i;
                book[i]=false;
            }
            System.out.println(deleteNum(n));
        }
    }

    private static int deleteNum(int n) {
        int sum=0;
        int index=0;
        while (sum<n-1){
            if(index>n-1) index=0;
            int dis=0;
            while (dis!=3) {
                if (index>n-1) index=0;
                if (!book[index])
                dis++;
                if (dis==3) break;

                //System.out.println(dis);
                index++;
            }
            //System.out.println(index);
            book[index]=true;
            index++;
            sum++;
        }
        for(int i=0;i<n;i++)
            if(!book[i]) return i;
        return 0;
    }

}
