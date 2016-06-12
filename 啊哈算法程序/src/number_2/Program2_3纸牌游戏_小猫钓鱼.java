package number_2;
/*
 * Test instance
 * input:
6
2 4 1 2 5 6
3 1 3 5 6 4
output:
小哈win！！！
小哈手中的牌是
1 6 5 2 3 4 1 
桌面上的牌是：3 4 5 6 2 
 */
import java.util.Scanner;
public class Program2_3纸牌游戏_小猫钓鱼 {
	private static Scanner sc;
	private static int n;
	private static class Queue{
		int[] data;
		int head;
		int tail;
		public Queue(int n) {
			// TODO Auto-generated constructor stub
			data=new int[n*10];
			this.head=0;
			this.tail=n;
		}
	}
	private static class Stack{
		int[] data;
		int top;
		public Stack(int n) {
			// TODO Auto-generated constructor stub
			this.data=new int[2*n+2];
			this.top=1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		n=sc.nextInt();
		Queue queue1=new Queue(n);
		Queue queue2=new Queue(n);
		for(int i=0;i<n;i++) queue1.data[i]=sc.nextInt();//小哼
		for(int i=0;i<n;i++) queue2.data[i]=sc.nextInt();//小哈
		int[] book=new int[10];
		Stack stack=new Stack(n);
		//初始化队列和栈
		for(int i=1;i<=9;i++) book[i]=0;
		while(queue1.head<queue1.tail&&queue2.head<queue2.tail){
			int t=queue1.data[queue1.head++];//小哼出一张牌
			if(book[t]==0){ //桌面上没该牌
				stack.data[stack.top++]=t;
				book[t]=1;
			}else {
				//小哼可以赢牌
				queue1.data[queue1.tail++]=t;
				while(stack.data[--stack.top]!=t){
					book[stack.data[stack.top]]=0;
					queue1.data[queue1.tail++]=stack.data[stack.top];
				}
				
				book[t]=0;
				queue1.data[queue1.tail++]=stack.data[stack.top];
			}
			
			if( queue1.head==queue1.tail) break;
			
			//小哈
			t=queue2.data[queue2.head++];//小哈出一张牌
			if(book[t]==0){ //桌面上没该牌
				stack.data[stack.top++]=t;
				book[t]=1;
			}else {
				//小哈可以赢牌
				queue2.data[queue2.tail++]=t;
				while(stack.data[--stack.top]!=t){
					book[stack.data[stack.top]]=0;
					queue2.data[queue2.tail++]=stack.data[stack.top];
				}
				
				book[t]=0;
				queue2.data[queue2.tail++]=stack.data[stack.top];
			}
			
			if( queue2.head==queue2.tail) break;
			
		}
		
		if (queue2.head==queue2.tail) {
			System.out.println("小哼win！！！\n小哼手中的牌是");
			for(int i=queue1.head;i<queue1.tail;i++) System.out.print(queue1.data[i]+" ");
			System.out.println();
			if(stack.top>=0){
				System.out.print("桌面上的牌是：");
				for(int i=1;i<stack.top;i++) System.out.print(stack.data[i]+" ");
				System.out.println();
			}else {
				System.out.println("桌面上没牌了");
			}
		}
		
		if (queue1.head==queue1.tail) {
			System.out.println("小哈win！！！\n小哈手中的牌是");
			for(int i=queue2.head;i<queue2.tail;i++) System.out.print(queue2.data[i]+" ");
			System.out.println();
			if(stack.top>=0){
				System.out.print("桌面上的牌是：");
				for(int i=1;i<stack.top;i++) System.out.print(stack.data[i]+" ");
				System.out.println();
			}else {
				System.out.println("桌面上没牌了");
			}
		}
		
	}

}
