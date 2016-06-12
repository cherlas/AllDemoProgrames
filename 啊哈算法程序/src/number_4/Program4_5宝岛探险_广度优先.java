package number_4;
/*
 * Test instance
 * 估计小哼所在岛屿面积大小
 * input:
10 10 6 8
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
 * output:面积是38
 */
import java.util.Scanner;

public class Program4_5宝岛探险_广度优先 {
	private static Scanner sc;
	private static int[][] book,a;
	private static int n,m,startX,startY;
	private static int[][] next=new int[][]{{0,1},//右
	    									{1,0},//下
	    									{0,-1},//左
	    									{-1,0}};//上
	private static class Note{
		int x;
		int y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int head,tail;
		Note[] queue=new Note[n*m+1];
		startX=sc.nextInt();
		startY=sc.nextInt();
		a=new int[n][m];
		book=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				a[i][j]=sc.nextInt();
				book[i][j]=0;
			}
		head=1;
		tail=1;
		queue[tail]=new Note();
		queue[tail].x=startX;
		queue[tail].y=startY;
		tail++;
		book[startX][startY]=1;
		int sum=1;
		while(head<tail){
			for(int i=0;i<4;i++){
				int tx=queue[head].x+next[i][0];
				int ty=queue[head].y+next[i][1];
				if(tx<0||tx>=n||ty<0||ty>=m) continue;
				if(a[tx][ty]>0&&book[tx][ty]==0){
					sum++;
					book[tx][ty]=1;
					queue[tail]=new Note();
					queue[tail].x=tx;
					queue[tail].y=ty;
					tail++;
				}
			}
			head++;
		}
		System.out.println("面积是"+sum);
	}

}
