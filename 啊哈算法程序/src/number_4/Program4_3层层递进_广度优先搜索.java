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
 *output:7
 */
import java.util.Scanner;

public class Program4_3层层递进_广度优先搜索 {
	private static Scanner sc;
	private static class Note{
		int x;//横坐标
		int y;//纵坐标
		//int f;//父亲在队列中的编号，输出路径用
		int s;//步数
	}
	private static int n,m,startX,startY,endX,endY;
	private static int[][] a,book;
	private static int[][] next=new int[][]{{0,1},//右
										    {1,0},//下
										    {0,-1},//左
										    {-1,0}};//上
	private static Note[] queue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();//n行m列
		queue=new Note[n*m+1];
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
		//初始化队列
		int head=1,tail=1;
		queue[tail]=new Note();
		queue[tail].x=startX;
		queue[tail].y=startY;
		//queue[tail].f=0;
		queue[tail].s=0;
		tail++;
		book[startX][startY]=1;
		boolean flag=false;//是否达到终点
		while(head<tail){
			//四个方向
			for(int i=0;i<4;i++){
				int tx=queue[head].x+next[i][0];
				int ty=queue[head].y+next[i][1];
				if(tx>n||tx<1||ty>m||ty<1) continue;
				if(a[tx][ty]==0&&book[tx][ty]==0){
					book[tx][ty]=1;
					queue[tail]=new Note();
					queue[tail].x=tx;
					queue[tail].y=ty;
					//queue[tail].f=head;
					queue[tail].s=queue[head].s+1;
					tail++;
				}
				if(tx==endX&&ty==endY){
					flag=true;
					break;
				}
				if (flag)  break;
			}
			head++;
		}
		System.out.println(queue[tail-1].s);
	}

}
