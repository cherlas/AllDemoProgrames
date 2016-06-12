package com.huawei.oj3;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class CalculateCharNew {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String originalString=sc.nextLine();
		calculateChar(originalString);

	}
	private static void calculateChar(String str){
		int numOfSingleChar[]=new int[256];
		for(int i=0;i<256;i++){
			numOfSingleChar[i]=0;
		}
		for(int i=0;i<str.length();i++){
			char cs=str.charAt(i);
			if((cs>='0'&&cs<='9')||(cs>='a'&&cs<='z')||(cs>='A'&&cs<='Z')||cs==' '){
				numOfSingleChar[cs]++;
			}
		}
		TreeSet<countChar> ts=new TreeSet<countChar>();
		for(int i=0;i<256;i++){
			if(numOfSingleChar[i]!=0)
				ts.add(new countChar((char)(i),numOfSingleChar[i]));	
		}
		Iterator<countChar> it=ts.iterator();
		while(it.hasNext()){
			System.out.print(it.next().ch);
		}
		
	}
static class countChar implements Comparable<countChar>{
	public char ch;
	public int count;
	public countChar() {};
	public countChar(char ch,int count){
		this.ch=ch;
		this.count=count;
	}
	@Override
	public int compareTo(countChar cc) {
		if (this.count>cc.count) {
			return -1;
		}else if (this.count<cc.count) {
			return 1;
		}else if (this.ch>cc.ch) {
			return 1;
		}else {
			return -1;
		}
	}
 }
}
