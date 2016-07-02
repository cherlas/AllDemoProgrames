package Demoes.unsucceed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/2.
 */
public class POJ_2785_4ValueswhoseSumis0 {
    private static int n;
    private static long[] A,B,C,D,CD;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        A=new long[n];
        B=new long[n];
        C=new long[n];
        D=new long[n];
        CD=new long[n*n];
        for(int i=0;i<n;i++) {
            A[i]=sc.nextInt();
            B[i]=sc.nextInt();
            C[i]=sc.nextInt();
            D[i]=sc.nextInt();
        }

        for (int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                CD[i*n+j]=C[i]+D[j];
        Arrays.sort(CD);
        long res=0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                long cd=-(A[i]+B[j]);
                res+=my_upper_bound(cd)-my_lower_bound(cd);
            }
        }
        System.out.println(res);
    }

    private static int my_lower_bound(long key)
    {
        int first = 0, last = n*n-1;
        int middle, pos=0;       //需要用pos记录第一个大于等于key的元素位置

        while(first < last)
        {
            middle = (first+last)/2;
            if(CD[middle] < key){      //若中位数的值小于key的值，我们要在右边子序列中查找，这时候pos可能是右边子序列的第一个
                first = middle + 1;
                pos = first;
            }
            else{
                last = middle;           //若中位数的值大于等于key，我们要在左边子序列查找，但有可能middle处就是最终位置，所以我们不移动last,
                pos = last;              //而是让first不断逼近last。
            }
        }
        return pos;
    }
    private static int my_upper_bound(long key)
    {
        int first = 0, last = n*n-1;
        int middle, pos = 0;

        while(first < last)
        {
            middle = (first+last)/2;
            if(CD[middle] > key){     //当中位数大于key时，last不动，让first不断逼近last
                last = middle;
                pos = last;
            }
            else{
                first = middle + 1;     //当中位数小于等于key时，将first递增，并记录新的位置
                pos = first;
            }
        }
        return pos;
    }

}
