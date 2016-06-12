package number_6;
/*
 * Test instance
 * //1号城市到5号城市的最短路径
 * input:
6 9
1 2 1
1 3 12
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4
 * output:
0 1 8 4 13 17 
 */
import java.util.Scanner;

public class Program6_2Dijkstra算法_单源最短路径 {
	private static Scanner sc;
	private static int[][] e;
	private static final int MAX=Integer.MAX_VALUE;
	private static int n,m;
	private static int[] book,dis;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		book=new int[n+1];
		dis=new int[n+1];
		e=new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++)
				if(i==j) e[i][j]=0;
				else e[i][j]=MAX;
			book[i]=0;
		}
		for(int i=1;i<=m;i++)
			e[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		for(int i=1;i<=n;i++)
			dis[i]=e[1][i];
		book[1]=1;
		//Dijkstra算法
		for(int i=1;i<n;i++){
			int min=MAX,u = 1;
			//最小值
			for(int j=1;j<=n;j++)
				if(book[j]==0&&dis[j]<min){
					min=dis[j];
					u=j;
				}
			book[u]=1;
			//松弛 u为中转 u-->v
			for(int v=1;v<=n;v++){
				if(e[u][v]<MAX){
					if(dis[v]>dis[u]+e[u][v])
						dis[v]=dis[u]+e[u][v];
				}
			}
			
		}
		
		for(int i=1;i<=n;i++)
			System.out.print(dis[i]+" ");
	}

}
