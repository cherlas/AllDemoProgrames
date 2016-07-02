package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/2.
 */
public class POJ_3279_Fliptile {
    private static int N,M;
    private static int[][] input,opt,filp;
    private static int[] dx=new int[]{-1,0,0,0,1},dy=new int[]{0,-1,0,1,0};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        M=sc.nextInt();
        N=sc.nextInt();
        input=new int[M][N];
        opt=new int[M][N];
        filp=new int[M][N];
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                input[i][j]=sc.nextInt();
        solve();

    }

    private static void solve() {
        int res=-1;
        for(int i=0;i<1<<N;i++){
            for(int j=0;j<M;j++)
                for(int k=0;k<N;k++)
                    filp[j][k]=0;
            for(int j=0;j<N;j++)
                filp[0][N-j-1]=i>>j&1;
            int num=calc();
            if(num>=0&&(res<0||res>num)){
                res=num;
                for(int k=0;k<M;k++)
                    for(int j=0;j<N;j++)
                        opt[k][j]=filp[k][j];
            }
        }
        if (res<0){
            System.out.println("IMPOSSIBLE");
        }else {
            //输出
            for (int k = 0; k < M; k++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(opt[k][j]);
                    if (j != N - 1)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    private static int calc() {
        for(int i=1;i<M;i++)
            for(int j=0;j<N;j++)
                if(getColor(i-1,j)!=0)
                    filp[i][j]=1;
        //最后一行是否空白
        for(int j=0;j<N;j++)
            if(getColor(M-1,j)!=0)
                return -1;
        //统计翻转次数
        int res=0;
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                res+=filp[i][j];
        return res;
    }

    private static int getColor(int x, int y) {
        int c=input[x][y];
        for(int d=0;d<5;d++){
            int tx=x+dx[d];
            int ty=y+dy[d];
            if(tx>=0&&tx<M&&ty>=0&&ty<N)
                c+=filp[tx][ty];
        }
        return c%2;
    }
}
