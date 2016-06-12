package com.huawei.oj3;
import java.util.Scanner;

public class NonRepeat {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(Integer.parseInt(str)==0||str.startsWith("-")){
			System.out.println(0);
		}else{
		int k=str.length()-1;
		int flag=0;
		while(str.charAt(k)=='0') {
			k--;
			flag=1;
		}
		String result=str.charAt(k)+"";
		for(int i=k-1; i>=0;i--){
			if(flag==1){
				if ((!result.contains(str.charAt(i)+""))&&str.charAt(i)!='0'){
					result=result+str.charAt(i);
				}
			}else {
				if (!result.contains(str.charAt(i)+"")) {
				result=result+str.charAt(i);
				}
			}
		}
		System.out.println(result);
		}
	}
}
