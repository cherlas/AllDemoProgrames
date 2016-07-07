package 华为机试体验;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/7.
 */
public class WordMaze {
    private static char[][] maze;
    private static char[] word;
    private static int wordLength,n,m;
    private static boolean isWord=false;
    private static boolean[][] book;
    private static int[] dx={1,0,-1,0},dy={0,1,0,-1};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        maze=new char[n][m];
        book=new boolean[n][m];
        for(int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                book[i][j]=false;
        sc.nextLine();
        word=sc.nextLine().toCharArray();
        wordLength=word.length;
        for(int i=0;i<n;i++)
            maze[i]=sc.nextLine().toCharArray();

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (maze[i][j]==word[0]){
                    dfs(i,j,0);
                }
                if (isWord){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    private static void dfs(int x, int y, int step) {
        if (isWord) return;
        if (step==wordLength-1){
            isWord=true;
            return;
        }

        step++;//System.out.println("step= "+step);
        book[x][y]=true;
        for (int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];
           // System.out.println("tx= "+tx+"  ty= "+ty);
            if (tx>=0&&ty>=0&&tx<n&&ty<m&&!book[tx][ty]&&maze[tx][ty]==word[step]){
                //System.out.println("tx= "+tx+"  ty= "+ty);
                dfs(tx,ty,step);
            }
            if (isWord) break;
        }
        return;
    }
}
