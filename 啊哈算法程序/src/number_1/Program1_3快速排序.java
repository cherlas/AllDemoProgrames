package number_1;
/*
 * Test instance
 * input:10 6 1 2 7 9 3 4 5 10 8
 * output:1 2 3 4 5 6 7 8 9 10 
 */
import java.util.Scanner;

public class Program1_3快速排序 {
	private static Scanner sc;
	private static int[] a;
	private static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		quickSort(0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
	private static void quickSort(int left, int right) {
		// TODO Auto-generated method stub
		if(left>=right) return;
		int provit=a[left];
		int i=left,j=right;
		while(i!=j){
			while(a[j]>=provit&&i<j) j--;//等于号
			while(a[i]<=provit&&i<j) i++;
			if(j>i) 
				swap(i,j);
		}
		//swap(left,i);
		a[left]=a[i];
		a[i]=provit;
		quickSort(left, i-1);
		quickSort(i+1, right);
		return;
	}
	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

}
