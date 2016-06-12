package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 密穴逃生 {
	public static int M,S,T,walkSpeed=17,lightingSpeed=60;
	public static int recoverySpeed=4,magicSpend=10,spendTime;
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str;
		int flag=0;
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
		
		if (S==0) {
			System.out.println("YES "+0);
			System.exit(0);
		}else
		if (T==0) {
			System.out.println("NO "+0);
		}
		
		
		new 密穴逃生().runOut();
	}
	public void runOut(){
		int distance;
		if (M/10*60>=S) {
			System.out.println("Yes "+M/10);
			System.exit(0);
		}else{
			spendTime=M/10;
			distance=spendTime*60;
			//System.out.println(M+" "+S+" "+T);
			System.out.println(distance+"  "+spendTime);
			int M1=M%10;
			for(int i=T-spendTime;i>=1;i--){
				System.out.println(i);
				if(((4*i+M1)/10*60>=17*i)){//&&((4*i+M1)/10*60+distance>=S)
					distance+=(4*i+M1)/10*60;
					spendTime+=i;
					System.out.println(distance+"  "+spendTime);
					break;
				}
					if (((4*i+M1)/10*60<17*i)) { //&&(17*i+distance>=S)
					distance+=17*i;
					spendTime+=i;
					break;
				}
				}
			
			if (distance>=S&&spendTime<=T) {
				System.out.println("Yes "+spendTime);
			
			}else if (distance<S) {
				System.out.println("NO "+distance);
			}
				
			
			
			
		}
	}
}
