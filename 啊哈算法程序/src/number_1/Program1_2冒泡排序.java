package number_1;
/*
 * Test instance
 * input:5 5 3 2 8 4
 * output:2 3 4 5 8
 */
import java.util.Scanner;

public class Program1_2冒泡排序 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=sc.nextInt();
		//冒泡
		for(int i=1;i<=n-1;i++){
			boolean flag=false;
			for(int j=1;j<n-i;j++){
				if(a[j]<a[j+1]){//从大到小
					flag=true;
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
			if (!flag) {
				break;
			}
		}
		for(int i=0;i<n;i++) System.out.print(a[i]+" ");
	}

}
