package number_2;
/*
 * Test instance
 * input:
9
2 3 5 8 9 10 18 26 32
6
 * output:
2 3 5 6 8 9 10 18 26 32
 */
import java.util.Scanner;
public class Program2_5模拟链表 {
	private static Scanner sc;
	private static final int RIGHT=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data=new int[n*2];
		int[] right=new int[n*2];
		for(int i=0;i<n;i++){
			data[i]=sc.nextInt();
			if(i!=n-1)
				right[i]=i+1;
			else
				right[i]=RIGHT;
		}
		//添加元素
		data[n]=sc.nextInt();
		
		
		int t=0;
		while(t!=RIGHT) {
			if(data[right[t]]>data[n]){
				right[n]=right[t];
				right[t]=n;
				break;
			}
			t=right[t];
		}
		n++;
		t=0;
		while(t!=RIGHT){
			System.out.print(data[t]+" ");
			t=right[t];
		}
		
	}

}
