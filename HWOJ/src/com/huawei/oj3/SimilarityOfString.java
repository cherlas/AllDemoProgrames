package com.huawei.oj3;
import java.util.Scanner;

public class SimilarityOfString {
	private static Scanner sc;
	private static String[] mSubString;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String strA=sc.nextLine();
		String strB=sc.nextLine();
		String distance=calculateStringDistance(strA,strB);
		System.out.println(distance);
	}
public static String calculateStringDistance(String expressionA,String expressionB) {
	int k = 0;
	if (expressionA.contains(expressionB)) {
		return "1/"+(expressionA.length()-expressionB.length()+1);
	}else if(expressionB.contains(expressionA)){
		return "1/"+(expressionB.length()-expressionA.length()+1);
	}else {
		int flag=0;		
		if(expressionA.length()>=expressionB.length()) {
			String str=expressionA;
			expressionA=expressionB;
			expressionB=str;
		}
		mSubString=new String[expressionA.length()+expressionB.length()];
		for(int i=0;i<expressionA.length();i+=k){
			k=1;
			for(int j=expressionA.length();j>i;j--){
				String sub=expressionA.substring(i,j);
				if(expressionB.contains(sub)&&sub.length()>=1){
					k=sub.length();
					mSubString[flag]=sub;
					flag++;
					break;
				}
			}
			
		}
		k=0;
		for(int i=0;i<flag;i++){
			k+=mSubString[i].length();
		}
	}
	
	return "1/"+(expressionB.length()-k+1);
 }
}
