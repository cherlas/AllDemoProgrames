package AllDemoes;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/9.
 */
public class 走迷宫 {
    private static class Walk{
        int x;
        int y;
        int step;
        public Walk(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static int[] dx={0,1,0,-1},dy={1,0,-1,0};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            char[][] maze=new char[10][10];
            for (int i=0;i<10;i++)
                maze[i]=sc.nextLine().toCharArray();
            Queue<Walk> queue=new ArrayDeque<>();
            Walk walk=new Walk(0,1);
            walk.step=0;
            queue.add(walk);
            boolean isEnd=false;
            int res=0;
            while (!queue.isEmpty()){
                Walk now=queue.poll();
                maze[now.x][now.y]='#';
                for (int i=0;i<4;i++){
                    int tx=now.x+dx[i];
                    int ty=now.y+dy[i];

                    if (tx==9&&ty==8){
                        isEnd=true;
                        res=now.step+1;
                        break;
                    }
                    if (tx>=0&&ty>=0&&tx<10&&ty<10&&maze[tx][ty]=='.'){
                        Walk walk1=new Walk(tx,ty);
                        walk1.step=now.step+1;
                        queue.add(walk1);
                    }
                }
                if (isEnd)
                    break;

            }
            System.out.println(res);

        }
        sc.close();
    }
}
