package AllDemoes.Important;

import java.util.Scanner;


/**
 * Created by Yogurt on 16/7/10.
 */
public class 红与黑 {
    private static char[][] house;
    private static int ans=0,m,n;
    private static int[] dx={1,0,-1,0},dy={0,1,0,-1};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        sc.nextLine();
        int startX = 0,startY=0;
        house=new char[m][n];
        for (int i=0;i<m;i++){
            String str=sc.nextLine();
            house[i]=str.toCharArray();
            if (str.contains("@")){
                startX=i;
                startY=str.indexOf("@");
            }
        }
        dfs(startX,startY);
        System.out.println(ans);
    }
    private static void dfs(int x,int y){
        ans++;
        house[x][y]='#';
        for (int i=0;i<4;i++){
            int tx=x+dx[i];
            int ty=y+dy[i];
            if (tx>=0&&ty>=0&&tx<m&&ty<n&&house[tx][ty]=='.')
                dfs(tx,ty);
        }
    }
}
