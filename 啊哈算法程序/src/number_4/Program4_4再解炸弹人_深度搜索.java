package number_4;
/*
 * Test instance
 * input:
13 13 3 3
#############
#GG.GGG#GGG.#
###.#G#G#G#G#
#.......#..G#
#G#.###.#.GG#
#GG.GGG.#.GG#
#G#.#G#.#.#.#
##G...G.....#
#G#.#G###.#G#
#...G#GGG.GG#
#G#.#G#G#.#G#
#GG.GGG#G.GG#
#############
 * output:炸弹放在(7,11)处，可以消灭10个敌人
 */
import java.util.Scanner;

public class Program4_4再解炸弹人_深度搜索 {
	private static Scanner sc;
	private static char[][] a=new char[21][21];
	private static int[][] book=new int[20][20];
	private static int n,m,mx,my,max=-1;
	private static int[][] next=new int[][]{{0,1},//右
										    {1,0},//下
										    {0,-1},//左
										    {-1,0}};//上
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++) 
				book[i][j]=0;
		
		n=sc.nextInt();
		m=sc.nextInt();
		int startX,startY;
		startX=sc.nextInt();
		startY=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++)
			a[i]=sc.nextLine().toCharArray();
		book[startX][startY]=1;
		dfs(startX,startY);
		System.out.println("炸弹放在("+mx+","+my+")处，可以消灭"+max+"个敌人");
		
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		int sum=getNum(x, y);
		if(sum>max){
			max=sum;
			mx=x;
			my=y;
		}
		for(int i=0;i<4;i++){
			int tx=x+next[i][0];
			int ty=y+next[i][1];
			if(tx<0||tx>=n||ty<0||ty>=m) continue;
			if(a[tx][ty]=='.'&&book[tx][ty]==0){
				book[tx][ty]=1;				
				dfs(tx, ty);
			}
		}
		return;
	}
	private static int getNum(int i,int j) {
		int x = i,y = j,sum=0;
		//向上统计可消灭敌人数
		while(a[x][y]!='#'){
			if(a[x][y]=='G') sum++;
			x--;
		}
		//向下
		x = i;y = j;
		while(a[x][y]!='#'){
			if(a[x][y]=='G') sum++;
			x++;
		}
		//向左
		x = i;y = j;
		while(a[x][y]!='#'){
			if(a[x][y]=='G') sum++;
			y--;
		}
		//向右
		x = i;y = j;
		while(a[x][y]!='#'){
			if(a[x][y]=='G') sum++;
			y++;
		}
		return sum;
	}
}
