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

public class Program4_4再解炸弹人_广度搜索 {
	private static Scanner sc;
	private static class Note{
		int x;
		int y;
	}
	private static char[][] a=new char[21][21];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Note[] queue=new Note[401];
		int head=1,tail=1;
		int[][] book=new int[20][20];
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++) 
				book[i][j]=0;
		int[][] next=new int[][]{{0,1},//右
								{1,0},//下
								{0,-1},//左
								{-1,0}};//上
		int sum,max=0,mx,my,startX,startY;
		int n=sc.nextInt();
		int m=sc.nextInt();
		startX=sc.nextInt();
		startY=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++)
			a[i]=sc.nextLine().toCharArray();
		
		book[startX][startY]=1;
		queue[tail]=new Note();
		queue[tail].x=startX;
		queue[tail].y=startY;
		tail++;
		max=getNum(startX, startY);
		mx=startX;
		my=startY;
		
		while(head<tail){
			for(int i=0;i<4;i++){
				int tx=queue[head].x+next[i][0];
				int ty=queue[head].y+next[i][1];
				if(tx<0||tx>=n||ty<0||ty>=m) continue;
				
				if (book[tx][ty]==0&&a[tx][ty]=='.') {
					book[tx][ty]=1;
					queue[tail]=new Note();
					queue[tail].x=tx;
					queue[tail].y=ty;
					tail++;
					sum=getNum(tx, ty);
					if (sum>max) {
						max=sum;
						mx=tx;
						my=ty;
					}
				}
			}
			head++;
		}
		
		System.out.println("炸弹放在("+mx+","+my+")处，可以消灭"+max+"个敌人");
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
