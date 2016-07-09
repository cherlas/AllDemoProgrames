package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/9.
 */
public class 过年回家_佛洛依德_迪杰斯特拉 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[][] graph=new int[n+1][n+1];
            for (int i=0;i<=n;i++)
                for (int j=0;j<=n;j++)
                    graph[i][j]=99999999;

            for (int i=0;i<m;i++)
                graph[sc.nextInt()][sc.nextInt()]=sc.nextInt();
            System.out.println(calculatePricewhithFloyed(n,graph));
            System.out.println(calculatePricewhithDjstla(n,graph));
        }
    }

    private static int calculatePricewhithDjstla(int n, int[][] graph) {
        int[] d=new int[n+1];
        boolean[] used=new boolean[n+1];
        for (int i=0;i<=n;i++)
            d[i]=99999999;
        d[0]=0;
        while (true){
            int v=-1;
            for (int i=0;i<=n;i++)
                if (!used[i]&&(v<0||d[i]<d[v])) v=i;
            if (v==-1) break;
            used[v]=true;
            for (int i=0;i<=n;i++)
                d[i]=Math.min(d[i],d[v]+graph[v][i]);
        }
        return d[n];
    }

    private static int calculatePricewhithFloyed(int n, int[][] graph) {
        for (int k=0;k<=n;k++)
            for (int i=0;i<=n;i++)
                for (int j=0;j<=n;j++)
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);

        return graph[0][n];
    }
}
