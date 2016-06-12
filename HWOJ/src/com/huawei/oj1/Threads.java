package com.huawei.oj1;

import java.util.Scanner;

public class Threads {
	private static Scanner sc;
	public static void main(String[] args) throws InterruptedException {
		sc=new Scanner(System.in);
		int n=sc.nextInt();
//		String string="";
//		for(int i=0;i<n;i++){
//			string+="ABCD";
//		}
//		System.out.println(string);
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n*4;i++){
			sb.append(" ");
		}
//		final boolean flag1=false,flag2=false,flag3=false,flag4=false;
		Thread th1=new Thread() {
			
			@Override
			public void run() {
				int i;
				for(i=0;i<n*4;i+=4){
					sb.replace(i, i+1, "A");
				}
				
			}
		};		
		Thread th2=new Thread(){			
			@Override
			public void run() {
				int i;
				for(i=1;i<n*4;i+=4){
					sb.replace(i, i+1, "B");
					
				}
				
			}
		};	
		Thread th3=new Thread() {
			
			@Override
			public void run() {
				int i;
				for(i=2;i<n*4;i+=4){
					sb.replace(i, i+1, "C");
				}
				
			}
		};
		Thread th4=new Thread() {
	
	@Override
	public void run() {
		int i;
		for(i=3;i<n*4;i+=4){
			sb.replace(i, i+1, "D");
			}		
		}
		};
	th1.start();
	th2.start();
	th3.start();
	th4.start();
	Thread.sleep(10);
//	System.out.println(th4.isAlive());
	System.out.println(sb);
	}
}
