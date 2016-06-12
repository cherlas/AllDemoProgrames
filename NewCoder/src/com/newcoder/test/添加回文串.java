package com.newcoder.test;

public class 添加回文串 {
	public static void main(String[] args){
			System.out.println(addToPalindrome("bbabbaaabba", 11));
	}
	
	public static String addToPalindrome(String A, int n) {
		if (A.length()==1||A.length()==0) {
			return "";
		}
		for(int i=n/2;i<n;i++){
			int begin=i*2-n>=0 ? i*2-n:0;
			String sub=reverse(A.substring(begin,i));
			if (sub.equals(A.substring(i,n))) {
				//System.err.println(reverse(A.substring(0,i*2+1-n))+"   "+i+"  "+sub);
				return reverse(A.substring(0,i*2-n));
			}
		}
		return reverse(A.substring(0,n-1));
	}
	
	public static String reverse(String str) {
		StringBuffer sb=new StringBuffer();
		for(int i=str.length()-1;i>=0;i--)
			sb.append(str.charAt(i));
		
		return sb.toString();
	}
}
