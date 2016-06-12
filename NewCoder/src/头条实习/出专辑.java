package 头条实习;

import java.util.Scanner;

public class 出专辑 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int s=sc.nextInt();
			int L=sc.nextInt();
			if (n>100||L<s||L>10000) {
				System.out.println(0);
			}else {
				System.out.println(calculateBulm(n,s,L));
			}
		}

	}
	
	private static int calculateBulm(int n,int s,int l) {
		if (n*s+n-1<=l) {
			if(n%13==0) return 2;
			else return 1;
		}
		int k=(int)(l+1)/(s+1);
		if(k%13==0) k--;
		if(n%k==0) return n/k;
		else if((n-k*(n/k))%13==0&&(k-(n-k*(n/k)))>1) {System.out.println("k="+k+"  "+(n/k));return n/k+1; }
		else if((n-k*(n/k))%13==0) return n/k+2; 
		else return n/k+1;
	}
}
