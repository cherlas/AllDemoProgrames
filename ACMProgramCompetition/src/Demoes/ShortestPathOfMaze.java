package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/6/30.
in:
10 10
#S######.#
......#..#
.#.##.##.#
.#........
##.##.####
....#....#
.#######.#
....#.....
.####.###.
....#...G#
out:
22
 */
public class ShortestPathOfMaze {
    private static char[][] input;
    private static int N,M,startX,startY,endX,endY;
    private static class Pair{
        int x;
        int y;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        input=new char[N][M];
        for(int i=0;i<N;i++){
            String str=sc.nextLine();
            for(int j=0;j<M;j++){
                input[i][j]=str.charAt(j);
                if(str.charAt(j)=='S'){
                    startX=i;
                    startY=j;
                }
                if(str.charAt(j)=='G'){
                    endX=i;
                    endY=j;
                }
            }
        }
        int[] nextX=new int[]{1,0,-1,0};
        int[] nextY=new int[]{0,1,0,-1};
        Pair[] queue=new Pair[N*M+2];
        int[][] d=new int[N][M];
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                d[i][j]=Integer.MAX_VALUE;
        int head=0,tail=0;
        queue[tail]=new Pair();
        queue[tail].x=startX;
        queue[tail].y=startY;
        tail++;
        d[startX][startY]=0;
        while(head<tail){
            int x=queue[head].x;
            int y=queue[head].y;
            if(x==endX&&y==endY) break;
            for(int i=0;i<4;i++){
                int tx=x+nextX[i];
                int ty=y+nextY[i];
                if(tx>=0&&ty>=0&&tx<N&&ty<M&&input[tx][ty]!='#'&&d[tx][ty]==Integer.MAX_VALUE){
                    queue[tail]=new Pair();
                    queue[tail].x=tx;
                    queue[tail].y=ty;
                    tail++;
                    d[tx][ty]=d[x][y]+1;
                }
            }
            head++;
        }
        System.out.println(d[endX][endY]);
    }
}
