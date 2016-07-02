package Demoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/2.
 */
public class POJ_1979_RedAndBlack {
    private static int w,h,startX,startY;
    private static char[][] input;
    private static int[] dx={0,1,0,-1},dy={1,0,-1,0};
    private static int sum=0;
    private static boolean[][] book;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        w=sc.nextInt();
        h=sc.nextInt();
        while (w!=0&&h!=0){
            sc.nextLine();
            input=new char[h][w];
            for(int i=0;i<h;i++){
                String str=sc.nextLine();
                if(str.contains("@")){
                    startX=i;
                    startY=str.indexOf("@");
                }
                input[i]=str.toCharArray();
            }
            book=new boolean[h][w];
            for(int i=0;i<h;i++)
                for(int j=0;j<w;j++)
                    book[i][j]=false;
            sum=0;
            dfs(startX,startY);
            System.out.println(sum);

            w=sc.nextInt();
            h=sc.nextInt();
        }
    }

    private static void dfs(int x, int y) {
        sum++;
        book[x][y]=true;
        for(int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];
            if(tx>=0&&tx<h&&ty>=0&&ty<w&&input[tx][ty]=='.'&&!book[tx][ty])
                dfs(tx,ty);
        }
        return;
    }
}
