package number_2;
/*
 * Test instance
 * input:9 6 3 1 7 5 8 9 2 4
 * output:615947283
 */
import java.util.Scanner;
public class Program2_1解密QQ号2 {
	private static Scanner sc;
	private static class Queue{
		int[] data;
		int head,tail;
		public Queue(int n) {
			// TODO Auto-generated constructor stub
			data=new int[101];
			for(int i=0;i<101;i++) data[i]=0;
			this.tail=n;
			this.head=0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		Queue queue=new Queue(n);
		for(int i=0;i<n;i++) queue.data[i]=sc.nextInt();
		while(queue.head<queue.tail){
			System.out.print(queue.data[queue.head++]);
			queue.data[queue.tail++]=queue.data[queue.head++];
		}
	}
}
