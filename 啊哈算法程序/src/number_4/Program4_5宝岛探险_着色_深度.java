package number_4;
/*
 * Test instance
 * 岛屿着色
 * input:
10 10
1 2 1 0 0 0 0 0 2 3
3 0 2 0 1 2 1 0 1 2
4 0 1 0 1 2 3 2 0 1
3 2 0 0 0 1 2 4 0 0
0 0 0 0 0 0 1 5 3 0
0 1 2 1 0 1 5 4 3 0
0 1 2 3 1 3 6 2 1 0
0 0 3 4 8 9 7 5 0 0
0 0 0 3 7 8 6 0 1 2
0 0 0 0 0 0 0 0 1 0
 * output:
-1 -1 -1  0  0  0  0  0 -2 -2
-1  0 -1  0 -3 -3 -3  0 -2 -2
-1  0 -1  0 -3 -3 -3 -3  0 -2
-1 -1  0  0  0 -3 -3 -3  0  0
 0  0  0  0  0  0 -3 -3 -3  0
 0 -3 -3 -3  0 -3 -3 -3 -3  0
 0 -3 -3 -3 -3 -3 -3 -3 -3  0
 0  0 -3 -3 -3 -3 -3 -3  0  0
 0  0  0 -3 -3 -3 -3  0 -4 -4
 0  0  0  0  0  0  0  0 -4  0
共有4个小岛
 */
import java.util.Scanner;

public class Program4_5宝岛探险_着色_深度 {
	private static Scanner sc;
	private static int[][] book,a;
	private static int n,m,num=0;
	private static int[][] next=new int[][]{{0,1},//右
	    									{1,0},//下
	    									{0,-1},//左
	    									{-1,0}};//上
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n][m];
		book=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				a[i][j]=sc.nextInt();
				book[i][j]=0;
			}
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				if(a[i][j]>0){
					num--;
					dfs(i, j, num);
				}
			}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(j==0){
					System.out.printf("%2d",a[i][j]);
				}else {
					System.out.printf("%3d",a[i][j]);
				}	
			}	
			System.out.println();
		}
		
		System.out.println("共有"+-num+"个小岛");
	}
	private static void dfs(int x, int y,int color) {
		// TODO Auto-generated method stub
		a[x][y]=color;
		for(int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if(tx<0||tx>=n||ty<0||ty>=m) continue;
			if(a[tx][ty]>0&&book[tx][ty]==0){
				book[tx][ty]=1;
				dfs(tx, ty,num);
			}
		}
		return;
	}

}
