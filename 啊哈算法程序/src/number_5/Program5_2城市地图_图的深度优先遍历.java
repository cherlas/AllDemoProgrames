package number_5;

import java.util.Scanner;

/*
 * Test instance
 * //1号城市到5号城市的最短路径
 * input:
5 8
1 2 2
1 5 10
2 3 3
2 5 7
3 1 4
3 4 4
4 5 5
5 3 3
 * output:
9
 */
public class Program5_2城市地图_图的深度优先遍历 {
	private static Scanner sc;
	private static final int MAX=Integer.MAX_VALUE;
	private static int min=MAX,n,m;
	private static int[] book;
	private static int[][] e;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		e=new int[n+1][n+1];
		book=new int[n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j) e[i][j]=0;
				else e[i][j]=MAX;
			}
			book[i]=0;
		}
		
		for(int i=0;i<m;i++) e[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		
		book[1]=1;
		dfs(1,0);
		System.out.println(min);
	}
	private static void dfs(int cur, int dis) {
		// TODO Auto-generated method stub
		if(dis>min) return;
		if(cur==n) {  //1号城市到5号城市的最短路径
			if(min>dis) min=dis;
			return;
		}
		
		for(int i=1;i<=n;i++){
			if(e[cur][i]!=MAX&&book[i]==0){
				book[i]=1;
				dfs(i, dis+e[cur][i]);
				book[i]=0;
			}
		}
		return;
	}

}
