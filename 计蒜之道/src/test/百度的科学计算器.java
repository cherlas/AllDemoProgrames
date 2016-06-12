package test;

import java.math.BigDecimal;
import java.util.Scanner;

public class 百度的科学计算器 {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		String st=sc.nextLine();
		if(st.length()>100) {
			System.out.println("Error");
			return;
		}
		String[] input=st.split("e");
		if(input[0].startsWith("+"))
			input[0]=input[0].substring(1);
		BigDecimal bigDecimal1=new BigDecimal(input[0]);
		bigDecimal1.stripTrailingZeros();
		
		int num1=0,num2=0;
		if(Math.abs(bigDecimal1.doubleValue())>=10.0){
			while(Math.abs(bigDecimal1.doubleValue())>=10.0){
				bigDecimal1=bigDecimal1.divide(new BigDecimal("10"));
				num1++;
			}
		}
		
		if(Math.abs(bigDecimal1.doubleValue())<1.0){
			while(Math.abs(bigDecimal1.doubleValue())<1.0&&Math.abs(bigDecimal1.doubleValue())>0.0){
				bigDecimal1=bigDecimal1.multiply(new BigDecimal("10"));
				num2++;
			}
		}
				
		input[0]=String.valueOf(bigDecimal1.doubleValue());
		String str=input[0].substring(input[0].indexOf(".")+1);
		if(Integer.parseInt(str)==0) input[0]=input[0].substring(0, input[0].indexOf("."));	
		if(input[1].startsWith("+"))
			input[1]=input[1].substring(1);
		BigDecimal bigDecimal2=new BigDecimal(input[1]);
		bigDecimal2.stripTrailingZeros();
			
		input[1]=bigDecimal2.toString();
		int b=Integer.parseInt(input[1]);
		b=b+num1-num2;
		//if(b==0) System.out.println(input[0]);
		if(b==0&&Double.parseDouble(input[0])==0)
			System.out.println(0);
		else
			System.out.println(input[0]+"e"+b);
	}

}
