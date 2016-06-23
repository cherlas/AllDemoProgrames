package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 测试样例：
 1
 返回：["down"]
 */
public class 折纸问题 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        foldPaper(n);

    }

    private static String[] foldPaper(int n) {
        int[] f=new int[n+1];
        f[1]=1;
        for(int i=2;i<=n;i++)
            f[i]=2*f[i-1]+1;
        if(n==1) return  new String[]{"down"};
        String[] result=new String[f[n]];
        calculateResult(result,0,f[n],1,n,"down");
        for(int i=0;i<f[n];i++)
            System.out.print(result[i]+" ");
        return  result;
    }

    private static void calculateResult(String[] result,int start, int end,int s ,int n,String str) {
        if (s==n+1) return;
        int mid=(start+end)/2;
        result[mid]=str;
        calculateResult(result,start,mid,s+1,n,"down");
        calculateResult(result,mid,end,s+1,n,"up");
    }
}
