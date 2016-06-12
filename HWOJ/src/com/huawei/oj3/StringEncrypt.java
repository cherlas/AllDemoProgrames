package com.huawei.oj3;
import java.util.Scanner;

public class StringEncrypt {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String[] strings=new String[2];
		for(int i=0;i<2;i++){
			String str=sc.nextLine();
			strings[i]=str;
		}
		char aucPassword[]=strings[0].toCharArray();
		char Result[]=strings[1].toCharArray();
		Encypt(aucPassword,null);
		unEncypt(Result,null);
	}
private static void Encypt(char aucPassword[],char aucResult[]) {
	for(int i=0;i<aucPassword.length;i++){
		if (aucPassword[i]>='a'&& aucPassword[i]<='z') {
			aucPassword[i]-=31;
			if (aucPassword[i]>'Z') {
				aucPassword[i]='A';
			}
		}else if(aucPassword[i]>='A'&& aucPassword[i]<='Z') {
			aucPassword[i]+=33;
			if (aucPassword[i]>'z') {
				aucPassword[i]='a';
			}
		}else if (aucPassword[i]>='0'&& aucPassword[i]<='9') {
			aucPassword[i]++;
			if (aucPassword[i]>'9') {
				aucPassword[i]='0';
			}
		}
	}
	
	System.out.println(aucPassword);
 }

private static void unEncypt(char Result[],char Password[]) {
	for(int i=0;i<Result.length;i++){
		if (Result[i]>='a'&& Result[i]<='z') {
			Result[i]-=33;
			if (Result[i]<'A') {
				Result[i]='Z';
			}
		}else if(Result[i]>='A'&& Result[i]<='Z') {
			Result[i]+=31;
			if (Result[i]<'a') {
				Result[i]='z';
			}
		}else if (Result[i]>='0'&& Result[i]<='9') {
			Result[i]--;
			if (Result[i]<'0') {
				Result[i]='9';
			}
		}
	}
	
	System.out.println(Result);
	
	
   }
}
