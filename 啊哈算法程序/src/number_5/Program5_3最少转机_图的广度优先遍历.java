package number_5;
/*
 * Test instance
 * //1号城市到5号城市的最短路径
 * input:
5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5
 * output:
2
 */
import java.util.Scanner;

public class Program5_3最少转机_图的广度优先遍历 {
	private static Scanner sc;
	private static class Note{
		int x;//城市编号
		int s;//转机次数
	}
	private static final int MAX=Integer.MAX_VALUE;
	private static int n,m,start,end;
	private static int[] book;
	private static int[][] e;
	private static Note[] queue;
	private static boolean flag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		start=sc.nextInt();
		end=sc.nextInt();
		queue=new Note[n*n+1];
		e=new int[n+1][n+1];
		book=new int[n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j) e[i][j]=0;
				else e[i][j]=MAX;
			}
			book[i]=0;
		}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			e[a][b]=1;
			e[b][a]=1;
		}
		
		int head=1,tail=1;
		queue[tail]=new Note();
		queue[tail].x=start;
		queue[tail].s=0;
		tail++;
		book[start]=1;
		int cur;
		while(head<tail){
			cur=queue[head].x;
			for(int i=1;i<=n;i++){
				if(e[cur][i]==1&&book[i]==0){
					book[i]=1;
					queue[tail]=new Note();
					queue[tail].x=i;
					queue[tail].s=queue[head].s+1;
					tail++;
				}
				if(queue[tail-1].x==end) {
					flag=true;
					break;
				}
			}
			if (flag)  break;
			head++;
		}
		System.out.println(queue[tail-1].s);
	}

}
