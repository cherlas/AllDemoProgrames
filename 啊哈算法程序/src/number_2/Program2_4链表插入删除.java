package number_2;
/*
 * Test instance
 * input:
9
2 3 5 8 9 10 18 26 32 
6 10
 * output:
2 3 5 6 8 9 10 18 26 32
2 3 5 6 8 9 18 26 32
 */
import java.util.Scanner;
public class Program2_4链表插入删除 {
	private static class Node{
		int data;
		Node next;
		public Node(int data,Node next) {
			// TODO Auto-generated constructor stub
			this.data=data;
			this.next=next;
		}
	}
	private static Scanner sc;
	private static Node head = null,temp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		//建立链表
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
		int a=sc.nextInt();
		insert(a);
		a=sc.nextInt();
		delete(a);
	}
	private static void delete(int a) { //删除a所在的节点
		// TODO Auto-generated method stub
		
		Node pre=null;
		temp=head;
		boolean flag=false;
		while(temp.data!=a){
			pre=temp;
			temp=temp.next;
			flag=true;
		}
		if(flag)
		pre.next=temp.next;
		else
			System.out.println("No node of a...");
		print();
	}
	private static void print() {
		// TODO Auto-generated method stub
		temp=head;
		while(temp!=null) {
			//System.out.println(11);
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	private static void insert(int a) {
		// TODO Auto-generated method stub
		if (a<=head.data) {
			head=new Node(a, head);
			return;
		}
		temp=head;
		Node pre=null;
		while(temp.data<a){
			pre=temp;
			temp=temp.next;
		}
		pre.next=new Node(a, temp);
		print();
	}

}
