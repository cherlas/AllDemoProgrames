package number_4;
/*
 * Test instance
 * input:
5 4
0 0 1 0
0 0 0 0
0 0 1 0
0 1 0 0
0 0 0 1
1 1 4 3
 * output:7
 */
import java.util.Scanner;

public class Program4_2解救小哈 {
	private static Scanner sc;
	private static int n,m,startX,startY,endX,endY,min;
	private static int[][] a,book;
	private static int[][] next=new int[][]{{0,1},//右
										    {1,0},//下
										    {0,-1},//左
										    {-1,0}};//上
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();//n行m列
		min=n*m*2;
		a=new int[n+1][m+1];
		book=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++){
				a[i][j]=sc.nextInt();
				book[i][j]=0;
			}
		startX=sc.nextInt();
		startY=sc.nextInt();
		endX=sc.nextInt();
		endY=sc.nextInt();
		book[startX][startY]=1;
		dfs(startX,startY,0);
		System.out.println(min);
	}
	private static void dfs(int x, int y,int step) {
		// TODO Auto-generated method stub
		if(x==endX&&y==endY){
			if(step<min)
				min=step;
			return;
		}
		for(int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if(tx>n||tx<1||ty>m||ty<1) continue;
			if (book[tx][ty]==0&&a[tx][ty]==0) {
				book[tx][ty]=1;
				dfs(tx, ty, step+1);
				book[tx][ty]=0;	
			}
		}
		return;
		
	}

}
