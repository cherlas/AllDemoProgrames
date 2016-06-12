package number_1;
/*
 * Test instance
 * input:5 5 3 2 8 4
 * output:2 3 4 5 8
 */
import java.util.Scanner;

public class Program1_1最快最简单的排序 {
	private static Scanner sc;
	private static final int MAX_VALUE=99;//输入数据里面最大的数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int[] a=new int[MAX_VALUE];
		int n=sc.nextInt();
		for(int i=0;i<MAX_VALUE;i++) a[i]=0;
		for(int i=0;i<n;i++){
			a[sc.nextInt()]++;
		}
		for(int i=0;i<MAX_VALUE;i++){
			if (a[i]!=0) {
				for(int j=0;j<a[i];j++){
					System.out.println(i);
				}
			}
		}
	}

}
