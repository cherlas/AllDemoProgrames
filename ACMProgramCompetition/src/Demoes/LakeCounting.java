package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
 * in
10 12
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.
 out:
 3
 */
public class LakeCounting {
    private static char[][] input;
    private static int N,M;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        input=new char[N][M];
        for(int i=0;i<N;i++){
            String str=sc.nextLine();
            for(int j=0;j<M;j++)
                input[i][j]=str.charAt(j);
        }
        int res=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j]=='W'){
                    res++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int x, int y) {
        input[x][y]='.';
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int tx=x+dx;
                int ty=y+dy;
                if(tx>=0&&tx<=N-1&&ty>=0&&ty<=M-1&&input[tx][ty]=='W')
                    dfs(tx,ty);
            }
        }
    }
}
