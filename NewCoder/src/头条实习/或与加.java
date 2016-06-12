package 头条实习;

import java.util.Scanner;

public class 或与加 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
//		System.out.println(('1'| '0')+"   "+(('1'-48)|('1'-48)));
		while(sc.hasNext()){			
			int x=sc.nextInt();
			int k=sc.nextInt();
			int count=0; int i=1,y = 0;
//			String str1=Long.toBinaryString(x);
//			while(str1.length()<32) str1="0"+str1;
			while(count!=k){
//				String str2=Long.toBinaryString(i);
//				char[] s1=str1.toCharArray();
//				while(str2.length()<32) str2="0"+str2;
//				char[] s2=str2.toCharArray();
//				String res="";
//				for(int j=0;j<32;j++) res+=(s1[j]-48)|(s2[j]-48); 
//				//System.out.println(res);
//				int xi=Integer.parseInt(res);
				if ((x|i)==(x+i)) {
					count++;
					y=i;
				}
				i++;
			}
			System.out.println(y);
		}
	}
}
