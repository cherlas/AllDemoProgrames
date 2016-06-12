package com.huawei.oj1;
import java.util.Scanner;

public class 字符串排序 {
	private static Scanner sc;
	private static String inputString;
	static String[] oriSubStrings=new String[128];
	static String[] lowerSubStrings=new String[128];
	private static StringBuffer sb=new StringBuffer();
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		inputString=sc.nextLine();
		sort();
		System.out.println(sb);
	}
private static void sort() {
	for(int i=0;i<inputString.length();i++){
		if (!((inputString.charAt(i)>='a'&&inputString.charAt(i)<='z')||(inputString.charAt(i)>='A'&&inputString.charAt(i)<='Z'))) {
			continue;
		}else {
			sb.append(inputString.charAt(i)+"");
		}
	}
	outer:
	for(int i=0;i<sb.length();i++){
		for(int j=i+1;j<sb.length();j++){
			if (Math.abs(sb.charAt(i)-sb.charAt(j))==32||Math.abs(sb.charAt(i)-sb.charAt(j))==0){
				String sub=sb.substring(i+1,j);
				sb.insert(j+1, sub);
				sb.replace(i+1, j, "");
				continue outer;
			}
		}
	}
	System.out.println(sb);
	int flag=0;
	int c=(int)sb.charAt(0);
	for(int i=0;i<sb.length();){
		String string="";	
		System.out.println(sb.charAt(i));
		System.out.println(c);
		System.exit(0);
		while((Math.abs(sb.charAt(i)-c)==0)||(Math.abs((int)sb.charAt(i)-c)==32)){
			if(i<string.length()){
				string=string+sb.charAt(i);
				i++;	
			}else {
				break;
			}	
		}
//		oriSubStrings[flag]=string;
//		lowerSubStrings[flag]=string.toLowerCase();
		flag++;
		c=(int)sb.charAt(i);
	}
	for(int i=0;i< flag;i++){
		for(int j=i+1;j<flag;j++){
			if (lowerSubStrings[i].charAt(lowerSubStrings[i].length()-1)>lowerSubStrings[j].charAt(lowerSubStrings[j].length()-1)) {
				swap(i,j);
			}
		}
	}
	sb.delete(0, sb.length());
	for(int i=0;i<flag;i++){
		sb.append(oriSubStrings[i]);
	}
	for(int i=0;i<inputString.length();i++){
		if (!((inputString.charAt(i)>='a'&&inputString.charAt(i)<='z')||(inputString.charAt(i)>='A'&&inputString.charAt(i)<='Z'))) {
			sb.insert(i, inputString.charAt(i));
		}
	}
 }

private static void swap(int i,int j) {
	String tmp=lowerSubStrings[i];
	lowerSubStrings[i]=lowerSubStrings[j];
	lowerSubStrings[j]=tmp;
	tmp=oriSubStrings[i];
	oriSubStrings[i]=oriSubStrings[j];
	oriSubStrings[j]=tmp;
}
}
