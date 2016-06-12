package number_2;
/*
 * Test instance
 * input:xyzyx
 * output:Yes
 */
import java.util.Scanner;
import java.util.Stack;

public class Program2_2解密回文_栈 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		Stack<Character> stack=new Stack<>();
		char[] data=sc.nextLine().toCharArray();
		for(int i=0;i<data.length/2;i++)
			stack.push(data[i]);
		int t=data.length%2==0 ? data.length/2:data.length/2+1;
		boolean flag=true;
		for(int i=t;i<data.length;i++){
			if(data[i]!=stack.pop()){
				flag=false;
				break;
			}
		}
		if (flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
