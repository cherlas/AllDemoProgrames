package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 点亮灯 {

	public static void main(String[] args) {
		
		int n = 0,endLight=0;
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		try {
			n=Integer.parseInt(br.readLine());
			if (n<0) {
				System.out.println("输入错误");
				System.exit(0);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		long time1=System.currentTimeMillis();
		for(int i=1;i<=n;i++){
			int count=0;
			for(int j=2;j<=i;j++){
				if(i%j==0){
					count++;
				}
			}
			if(count%2==0){
				endLight++;
			}
		}
		
		System.out.println(endLight);
		Long time2=System.currentTimeMillis();
		Long spendTime=time2-time1;
		System.out.println("SpendTime is: "+spendTime);
	}

}
