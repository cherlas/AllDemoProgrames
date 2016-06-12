package number_4;
/*
 * 全排列
 */
import java.util.Scanner;

public class Program4_1不撞南墙不回头_深度优先算法 {
	private static Scanner sc;
	private static int n;
	private static int[] a=new int[10],book=new int[11];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=0;i<=10;i++) book[i]=0;
		dfs(1);
	}
	private static void dfs(int step) { //step为步数
		// TODO Auto-generated method stub
		if( step==(n+1)){
			for(int i=1;i<=n;i++)
				System.out.print(a[i]+" ");
			System.out.println();
			return;
		}
		//按照1、2、3……顺序依次去试
		for(int i=1;i<=n;i++){
			if(book[i]==0){
				a[step]=i;
				book[i]=1;
				dfs(step+1);
				book[i]=0;
			}
		}
		return;
	}

}
