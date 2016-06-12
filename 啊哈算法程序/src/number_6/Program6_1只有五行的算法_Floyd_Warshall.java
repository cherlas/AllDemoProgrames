package number_6;
/*
 * Test instance
 * //1号城市到5号城市的最短路径
 * input:
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12
 * output:
0 2 5 4 
9 0 3 4 
6 8 0 1 
5 7 10 0 
 */
import java.util.Scanner;

public class Program6_1只有五行的算法_Floyd_Warshall {
	private static Scanner sc;
	private static int[][] e;
	private static final int MAX=Integer.MAX_VALUE;
	private static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		e=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i==j) e[i][j]=0;
				else e[i][j]=MAX;
		for(int i=1;i<=m;i++)
			e[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(e[i][k]<MAX&&e[k][j]<MAX&&e[i][j]>e[i][k]+e[k][j])
						e[i][j]=e[i][k]+e[k][j];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++)
				System.out.print(e[i][j]+" ");
			System.out.println();
		}
	}

}
