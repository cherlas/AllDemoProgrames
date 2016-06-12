package number_4;
/*
 * Test instance
 * 估计小哼所在岛屿面积大小
 * input:
5 4
5 3 5 3
1 5 3 0
2 3 5 1
6 1 1 5
1 5 5 4
 * output:
(1,1) (1,2) (2,2) (3,2) (3,3) (3,4) (4,4) (5,4)
 */
import java.util.Scanner;

public class Program4_6水管工游戏 {
	private static Scanner sc;
	private static class Note{
		int x;
		int y;
	}
	private static Note[] queue=new Note[100];
	private static int[][] a,book;
	private static int top=0,n,m;
	private static boolean flag=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n+1][m+1];
		book=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
			for(int j=1;j<=m;j++){
				a[i][j]=sc.nextInt();
				book[i][j]=0;
			}
		dfs(1,1,1);//0，0开始，进水方向是1
		if(!flag) System.out.println("impossible!!");
	}
	private static void dfs(int x, int y, int front) {
		// TODO Auto-generated method stub
		if((x==n)&&(y==m)){
			flag=true;
			for(int i=1;i<=top;i++){
				System.out.printf("(%d,%d) ",queue[i].x,queue[i].y);
			}
			System.out.printf("(%d,%d)\n",x,y);
			return;
		}
		if(x<1||x>n||y<1||y>m||book[x][y]==1||flag) return;
		
		book[x][y]=1;
		top++;
		queue[top]=new Note();
		queue[top].x=x;
		queue[top].y=y;
		
		
		//当前水管是只管情况
		if(a[x][y]>=5&&a[x][y]<=6){
			if(front==1){//左侧进水
				dfs(x, y+1, 1);//只能用5号方式
			}
			
			if(front==2){//上侧进水
				dfs(x+1, y, 2);//只能用6号方式
			}
			
			if(front==3){//右侧进水
				dfs(x, y-1, 3);//只能用5号方式
			}
			
			if(front==4){//下侧进水
				dfs(x-1, y, 1);//只能用6号方式
			}
				
		}
		
		//当前水管为弯管的情况
		if (a[x][y]>=1&&a[x][y]<=4) {
			if(front==1){//左侧进水
				dfs(x+1, y, 2);//3号方式
				dfs(x-1, y, 4);//4号方式
			}
			
			if(front==2){//上侧进水
				dfs(x, y+1, 1);//1号方式
				dfs(x, y-1, 3);//4号方式
			}
			
			if(front==3){//右侧进水
				dfs(x+1, y, 2);//2号方式
				dfs(x-1, y, 4);//1号方式
			}
			
			if(front==4){//下侧进水
				dfs(x, y+1, 1);//2号方式
				dfs(x, y-1, 3);//3号方式
			}
			
		}
		book[x][y]=0;//取消标记
		top--;//当前尝试坐标出栈
		return;
	}

}
