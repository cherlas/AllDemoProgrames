package com.huawei.oj1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Error{
	String errorFile;
	String address;
	int num;
}
public class WrongRecords自己的 {
	private static Scanner sc;
	private static List<Error> list=new ArrayList<>();
	public static void main(String[] args) {
		String input;
		sc=new Scanner(System.in);
		while(sc.hasNext()){
			input=sc.nextLine();
			String[] errorMessage=input.split(" ",2);  //重要
			
			if (!(errorMessage.length==0)) {
				add(errorMessage[0].trim(),errorMessage[1].trim());
	//			System.out.println(input+"  "+errorMessage[0].trim()+"  "+errorMessage[1].trim());
			}
			
		}
		print();
		
	}
private static void print() {
	if (list.size()>8) {
		for(int i=list.size()-8;i<list.size();i++)
		System.out.println(list.get(i).errorFile+" "+list.get(i).address+" "+list.get(i).num);
	}else {
		for(Error error:list){
			System.out.println(error.errorFile+" "+error.address+" "+error.num);
	}
	}
}
private static void add(String str1,String str2) {
	String sub;
	if(str1.length()>16){
		if (str1.length()-str1.lastIndexOf("\\")>16) {
			sub=str1.substring(str1.length()-16, str1.length());
		}else {
			sub=str1.substring(str1.lastIndexOf("\\")+1, str1.length());
		}
	}else {
		sub=str1.substring(str1.lastIndexOf("\\")+1, str1.length());
	}
	if(list.size()==0){
		Error er=new Error();
		er.errorFile=sub;
		er.address=str2;
		er.num=1;
		list.add(er);
	}else {
		boolean flag=false;
		if (list.size()>8) {
			for(int i=list.size()-8;i<list.size();i++)			
			if(list.get(i).errorFile.equals(sub)&&list.get(i).address.equals(str2)){
				flag=true;
				Error error2=new Error();
				error2.address=str2;
				error2.errorFile=sub;
				int k=list.get(i).num;
				error2.num=k+1;
				list.set(i, error2);
				break;
			}
		}else {
			for(int i=0;i<list.size();i++)
				if(list.get(i).errorFile.equals(sub)&&list.get(i).address.equals(str2)){
					flag=true;
					Error error2=new Error();
					error2.address=str2;
					error2.errorFile=sub;
					int k=list.get(i).num;
					error2.num=k+1;
					list.set(i, error2);
					break;
				}
		}		
		if (!flag) {
			Error error=new Error();
			error.errorFile=sub;
			error.address=str2;
			error.num=1;
			list.add(error);
		}
	}	
}
}


//E:\V1R2\product\fpgadrive.c 1325
//E:\V1R2\product\fpgadrive.c 1326
//E:\V1R2\product\fpgadrive.c 1327
//E:\V1R2\product\fpgadrive.c 1328
//E:\V1R2\product\fpgadrive.c 1324
//E:\V1R2\product\fpgadrive.c 1323
//E:\V1R2\product\fpgadrive.c 1322
//E:\V1R2\product\fpgadrive.c 1321
//E:\V1R2\product\fpgadrive.c 1322
//E:\V1R2\product\fpgadrive.c 1325
//E:\V1R2\product\fpgadrive.c 1325