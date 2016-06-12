package com.huawei.oj1;
import java.util.Scanner;

public class LongestNumberString {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String string=sc.nextLine();
		int flag=0;
		for(int i=0;i<string.length();i++){
			if(string.charAt(i)>='0'&&string.charAt(i)<='9'){
				flag=1;
			}
		}
		
		if (flag==0||string.length()==0) {
			System.out.println(0);
		}else {
			String[] sub=string.split("[^0-9]");//非0-9   string.split("[a-zA-Z]");
			int max=0;
			String result=null;
			for(int i=0;i<sub.length;i++){
				if(sub[i].length()>max){
					max=sub[i].length();
					result=sub[i];
				}
			}
			System.out.println(result+","+max);
		}
	}
}
