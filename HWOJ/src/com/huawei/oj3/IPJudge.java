package com.huawei.oj3;
import java.awt.Checkbox;
import java.util.Scanner;

public class IPJudge {
	public static void main(String[] args) {
		String ipAddress1,ipAddress2,subNetMask;
		Scanner sc=new Scanner(System.in);
		subNetMask=sc.nextLine();
		ipAddress1=sc.nextLine();
		ipAddress2=sc.nextLine();
		
		int checkReturn=check(ipAddress1,ipAddress1,subNetMask);
		if (checkReturn==1) {
			
			System.out.println(1);
		}else {
			ipJudge(ipAddress1,ipAddress2,subNetMask);
		}
	}
private static int check(String ipAddress1,String ipAddress2,String subNetMask) {
		String[] ipAdd1=ipAddress1.split("\\.");
		String[] ipAdd2=ipAddress2.split("\\.");
		String[] subNet=subNetMask.split("\\.");
		if (ipAdd1.length!=4||ipAdd2.length!=4||subNet.length!=4) {
			return 1;
		}else {
			for(int i=0;i<4;i++){
				if((Integer.parseInt(ipAdd1[i])<0||Integer.parseInt(ipAdd1[i])>255)||(Integer.parseInt(ipAdd2[i])<0||Integer.parseInt(ipAdd2[i])>255)||(Integer.parseInt(subNet[i])<0||Integer.parseInt(subNet[i])>255)){
					return 1;
				}
			}
		}
		
		return 0;
	}

private static void ipJudge(String ipAddress1,String ipAddress2,String subNetMask) {
	String[] ipAdd1=ipAddress1.split("\\.");
	String[] ipAdd2=ipAddress2.split("\\.");
	String[] subNet=subNetMask.split("\\.");
	 
	int [] intIpAdd1=new int[4];
	int [] intIpAdd2=new int[4];
	int [] intSubNet=new int[4];
	for(int i=0;i<4;i++){
		intIpAdd1[i]=Integer.parseInt(ipAdd1[i]);
		intIpAdd2[i]=Integer.parseInt(ipAdd2[i]);
		intSubNet[i]=Integer.parseInt(subNet[i]);
	}
	int flag=0;
	for(int i=0;i<4;i++){
		int int1 =Integer.parseInt(Integer.toBinaryString(intIpAdd1[i]),2);
		int int2 =Integer.parseInt(Integer.toBinaryString(intSubNet[i]),2);
		int int3 =Integer.parseInt(Integer.toBinaryString(intIpAdd2[i]),2);
		if((int1&int2)==(int2&int3)){
			flag++;
		}
	}
	if(flag==4){
		System.out.println(0);
	}else {
		System.out.println(2);
	}
}
}
