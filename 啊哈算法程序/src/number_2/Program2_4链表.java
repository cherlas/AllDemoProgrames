package number_2;
/*
 * Test instance
 * input:
9
2 3 5 8 9 10 18 26 32
 * output:
2 3 5 8 9 10 18 26 32
 */
import java.util.Scanner;

public class Program2_4链表 {
	private static Scanner sc;
	private static class Node{
		int data;
		Node next;
		public Node(int data,Node next) {
			// TODO Auto-generated constructor stub
			this.data=data;
			this.next=next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		Node head = null,temp = null;
		for(int i=0;i<n;i++){
			int a=sc.nextInt();
			if(i==0){
				head=new Node(a, null);
				temp=head;
				continue;
			}
			temp.next=new Node(a, null);
			temp=temp.next;
		}
		temp=head;
		while(temp!=null) {
			//System.out.println(11);
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

}
