package 头条实习;

import java.util.Scanner;

public class 回文解码 {
	private static Scanner sc;
	private static StringBuffer sb;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNext()){			
			sb=new StringBuffer(sc.nextLine());
			if (sb.length()>10) 
				sb=new StringBuffer(sb.substring(0, 9));			
				int n=sc.nextInt();
				for(int i=0;i<n;i++){
					int p=sc.nextInt();
					int l=sc.nextInt();
					sb.insert(p+l,inverse(p, l));
			}
			if (sb.length()>1000) 
				System.out.println(sb.substring(0, 999));
			else 
				System.out.println(sb.toString());			
			sb.delete(0, sb.length());
		}
	}
	
	private static String inverse(int start,int len) {
		String string=sb.substring(start,start+len);
		StringBuffer sb1=new StringBuffer();
		for(int i=string.length()-1;i>=0;i--)
			sb1.append(string.charAt(i));
		return sb1.toString();
	}
}
