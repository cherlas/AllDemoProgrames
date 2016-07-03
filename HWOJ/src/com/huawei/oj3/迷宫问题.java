package com.huawei.oj3;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/3.
 */
public class 迷宫问题 {
    private static int N,M;
    private static int[][] maze;
    private static boolean[][] book;
    private static int[] dx={1,0,-1,-1},dy={0,1,0,-1};
    private static int head=0,top=0;
    private static class Path{
        int x;
        int y;
        public Path(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static Path[] path;
    private static boolean succeed=false;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        maze=new int[N][M];
        book=new boolean[N][M];
        path=new Path[N*M];
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++){
                maze[i][j]=sc.nextInt();
                book[i][j]=false;
            }

        dfs(0,0);
        for(int i=head;i<top;i++)
            System.out.println("("+path[i].x +","+path[i].y+")");
    }

    private static void dfs(int x, int y) {
        path[top++]=new Path(x,y);
        book[x][y]=true;
        if (x==N-1&&y==M-1){
            succeed=true;
            return;
        }
        for(int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];
            if(tx>=0&&ty>=0&&tx<N&&ty<M&&!book[tx][ty]&&maze[tx][ty]!=1) {
                dfs(tx, ty);
                if (succeed) break;
                top--;
            }
        }
        return;
    }
}
