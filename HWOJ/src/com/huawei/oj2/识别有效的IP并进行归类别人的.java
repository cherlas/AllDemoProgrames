package com.huawei.oj2;

import java.util.*;

public class 识别有效的IP并进行归类别人的 {
	//检验普通ip的合法性
	 public static boolean validateIpAddress(String str) {
	    	String[] ips = str.split("\\.");
	        for (int i = 0; i < ips.length; i++) {
	            Integer val = Integer.parseInt(ips[i]);
	            if (val>255) {
					return false;
				}
	        }
	        return true;
	    
	    }
	//检验子网掩码的合法性
	public static boolean validateGateIpAddress(String ip){
		if (!validateIpAddress(ip)) {
			return false;
		}
		String[] ips = ip.split("\\.");
        String binaryVal = "";
        for (int i = 0; i < ips.length; i++)
        {
            String binaryStr = Integer.toBinaryString(Integer.parseInt(ips[i]));
            binaryVal += binaryStr;
        }
        String regx = "^[1]*^[0]*$";
        // 255.255.255.255 , 255.255.255.31  类似这样的都不是合法子网掩码 
        // 255.63.255.0  //这样的是合法的子网掩码
        // 综上所述：子网掩码必须包含0和1，全0和全1均不行，前面是连续的1，然后全是0
        if (!binaryVal.contains("0")) {
        	return false;
		}
        if (!binaryVal.contains("1")) {
        	return false;
		}
        int a1=binaryVal.indexOf("0");
        if (binaryVal.substring(a1, binaryVal.length()).contains("1")) {
        	return false;
		}
        return true;
	}
	// 合法ip地址转成long型整数,用于判断 属于哪类的IP地址
	public static long ipToLong(String ipstr){
		long result = 0;
		StringTokenizer token = new StringTokenizer(ipstr, ".");
		result +=Long.valueOf(token.nextToken())<<24;
		result +=Long.valueOf(token.nextToken())<<16;
		result +=Long.valueOf(token.nextToken())<<8;
		result +=Long.valueOf(token.nextToken());
		return result;
	}
	// A类-E类 ip地址的判断
	public static boolean isAIpAddress(String ipstr){
		return  ipToLong(ipstr)>=ipToLong("1.0.0.0")&&ipToLong(ipstr)<=ipToLong("126.255.255.255");
	}
	public static boolean isBIpAddress(String ipstr){
		return  ipToLong(ipstr)>=ipToLong("128.0.0.0")&&ipToLong(ipstr)<=ipToLong("191.255.255.255");
	}
	public static boolean isCIpAddress(String ipstr){
		return  ipToLong(ipstr)>=ipToLong("192.0.0.0")&&ipToLong(ipstr)<=ipToLong("223.255.255.255");
	}
	public static boolean isDIpAddress(String ipstr){
		return  ipToLong(ipstr)>=ipToLong("224.0.0.0")&&ipToLong(ipstr)<=ipToLong("239.255.255.255");
	}
	public static boolean isEIpAddress(String ipstr){
		return  ipToLong(ipstr)>=ipToLong("240.0.0.0")&&ipToLong(ipstr)<=ipToLong("255.255.255.255");
	}
	//私网ip的判断
	public static boolean isPrivateIpAddress(String ipstr){
		boolean flag1 = ipToLong(ipstr)>=ipToLong("10.0.0.0")&&ipToLong(ipstr)<=ipToLong("10.255.255.255");
		boolean flag2 = ipToLong(ipstr)>=ipToLong("172.16.0.0")&&ipToLong(ipstr)<=ipToLong("172.31.255.255");
		boolean flag3 = ipToLong(ipstr)>=ipToLong("192.168.0.0")&&ipToLong(ipstr)<=ipToLong("192.168.255.255");
		return  flag1||flag2||flag3;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int A=0,B=0,C=0,D=0,E=0,error=0,P=0;
		while (cin.hasNextLine()) {
			String[] arr = cin.nextLine().split("~");
			//在一次输入中，ip地址错误或者掩码错误就+1，两个都错也是+1而不是+2
			if(!validateIpAddress(arr[0])||!validateGateIpAddress(arr[1]))
				error++;
			if(validateIpAddress(arr[0])&&validateGateIpAddress(arr[1])){
				if(isAIpAddress(arr[0]))
					A++;
				if(isBIpAddress(arr[0]))
					B++;
				if(isCIpAddress(arr[0]))
					C++;
				if(isDIpAddress(arr[0]))
					D++;
				if(isEIpAddress(arr[0]))
					E++;
				if(isPrivateIpAddress(arr[0]))
					P++;
			}
		}
		System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+error+" "+P);
	}
}