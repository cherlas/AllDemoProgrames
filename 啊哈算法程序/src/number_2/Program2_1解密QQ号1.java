package number_2;
/*
 * Test instance
 * input:9 6 3 1 7 5 8 9 2 4
 * output:615947283
 */
import java.util.Scanner;
public class Program2_1解密QQ号1 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int[] queue=new int[102];
		for(int i=0;i<102;i++) queue[i]=0;
		int n=sc.nextInt();
		for(int i=0;i<n;i++) queue[i]=sc.nextInt();
		int head=0,tail=n;
		while(head<tail){
			System.out.print(queue[head++]);
			queue[tail++]=queue[head++];
		}
	}

}
