package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 密穴逃生2 {
	public static int M,S,T,walkSpeed=17,lightingSpeed=60;
	public static int recoverySpeed=4,magicSpend=10,spendTime;
	public static void main(String[] args) throws  IOException {
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String str;
			int flag=0;
			boolean fla=false;
			int distance1 = 0,distance2=0;
			while(((str=br.readLine())!=null)&&(flag<3)){
				switch (flag) {
				case 0:
					M=Integer.parseInt(str);
					flag++;
					break;
				case 1:
					S=Integer.parseInt(str);
					flag++;
					break;
				case 2:
					T=Integer.parseInt(str);
					flag++;
					break;
				}
			}
			int start=T;
			if (S==0) {
				System.out.println("YES "+0);
				System.exit(0);
			}else
			if (T==0) {
				System.out.println("NO "+0);
			}else {
				while(T!=0){
					T--;
					if (M>=10) {
						M-=10;
						distance1+=60;
					}
						
					distance2+=17;
					if (distance2<distance1) {
						distance2=distance1;
						M+=4;
					}
					if (distance2>=S) {
						fla=true;
						break;
					}
				}
				if (fla) {
					System.out.println("Yes "+(start-T));
				}else {
					System.out.println("NO "+distance2);
				}
			}
			
	}

}
