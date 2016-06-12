package com.huawei.unsuccessed;
import java.util.Scanner;

public class LearnEnglish2 {
	
	private static Long num;
	private static Scanner sc;
	private static String[] everyThree=null;
	private static int everyflag=0;
	private static String[] numbers1=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
	private static String[] numbers2=new String[]{"","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	private static String[] numbers3=new String[]{"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};	
	private static String[] keyWords=new String[]{"and","hundred","thousand","million","billion"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
		num=sc.nextLong();
		String string=parse(num);
		System.out.println(string);
	}

	public static String parse(long num) {
		
		String str = "";
		String stringNum=String.valueOf(num);
		everyThree=new String[stringNum.length()/3+1];
		if (num<0||stringNum.length()>10) {
			return "“error”";
		}else {
			int num1=(int) (num%1000);
			int flag=2;
			long num2=num/1000;
			if(num2==0){
				str=str+read(num1);
			}else {
				while (num2!=0){
				String string=read(num1);
				if (string=="") {
					num1=(int) (num2%1000);
					num2=num2/1000;	
					flag++;
					continue;
				}else if(num2!=0){
					str=" "+keyWords[flag]+" "+string+str;
				}else if(num2==0){
					str=string+str;
				}
				
				flag++;
				num1=(int) (num2%1000);
				num2=num2/1000;	
			}	
				
				if (stringNum.length()>9) {
					if (Integer.parseInt(everyThree[0])==0&&Integer.parseInt(everyThree[1])==0&&Integer.parseInt(everyThree[2])==0) {
					str=read(num1)+str+" "+keyWords[4];
				}else if (Integer.parseInt(everyThree[0])==0&&Integer.parseInt(everyThree[1])!=0&&Integer.parseInt(everyThree[2])==0) {
					str=read(num1)+str+" "+keyWords[2];
				}else if (Integer.parseInt(everyThree[0])!=0&&Integer.parseInt(everyThree[1])==0&&Integer.parseInt(everyThree[2])!=0) {
					str=read(num1)+str;
					StringBuffer sBuffer=new StringBuffer(str);
					int k=sBuffer.indexOf(keyWords[2]);
					sBuffer.replace(k, k+keyWords[2].length(), keyWords[3]);
					str=sBuffer.toString();
				}else if (Integer.parseInt(everyThree[0])!=0&&Integer.parseInt(everyThree[1])!=0&&Integer.parseInt(everyThree[2])==0) {
					str=read(num1)+str;
					StringBuffer sBuffer=new StringBuffer(str);
					int k=sBuffer.indexOf(keyWords[3]);
					sBuffer.replace(k, k+keyWords[3].length(), keyWords[4]);
					str=sBuffer.toString();
				}else{
					str=read(num1)+str;
				}
				}else if (stringNum.length()>6) {
					
					if(Integer.parseInt(everyThree[0])==0&&Integer.parseInt(everyThree[1])==0){
						str=read(num1)+str+" "+keyWords[3];
					}else if(Integer.parseInt(everyThree[0])==0&&Integer.parseInt(everyThree[1])!=0){
						str=read(num1)+str+" "+keyWords[2];
					}else if (Integer.parseInt(everyThree[0])!=0&&Integer.parseInt(everyThree[1])==0) {
						str=read(num1)+str;
						StringBuffer sBuffer=new StringBuffer(str);
						int k=sBuffer.indexOf(" ");
						sBuffer.replace(k+1, sBuffer.indexOf(" ", k+1), keyWords[3]);
						str=sBuffer.toString();
					}
				}else {
					str=read(num1)+str;
				}				
			}				
		}
		
		return str;
	}
	
	
	private static String read(int threeNum){
		String threeNumbersString="";
		int tmp1=threeNum/100;
		int tmp2=threeNum%100;
		String threeNumString=String.valueOf(threeNum);
		everyThree[everyflag]=threeNumString;
		everyflag++;
		if(threeNumString.length()==3){
			if (tmp1!=0&&tmp2!=0) {
			threeNumbersString=numbers1[tmp1]+" "+keyWords[1]+" "+keyWords[0]+" ";//不是整百
			if (tmp2%10 != 0 && tmp2/10 != 1) {  //321 类型
				threeNumbersString+=numbers3[tmp2/10]+" "+numbers1[tmp2%10];
			}else if(tmp2%10 != 0 && tmp2/10 == 1){ //311
				threeNumbersString+=numbers2[tmp2%10];
			}else if (tmp2%10==0&& tmp2/10!=0) {  //320
				threeNumbersString+=numbers3[tmp2/10];
			}else if (tmp2%10!=0&&tmp2/10==0) {
				threeNumbersString+=numbers1[tmp2%10];
			}
		}else if(tmp1!=0&&tmp2==0){//整百
			threeNumbersString=numbers1[tmp1]+" "+keyWords[1];
		}else if (tmp1==0&&tmp2==0) { 
			threeNumbersString="";
	     }
		}else if (threeNumString.length()==2) {
			if (tmp1==0&&tmp2!=0) {
			if(tmp2%10==0){  //20 10...
				threeNumbersString+=numbers3[tmp2/10];
			}else if (tmp2%10!=0&&tmp2/10!=1) {  //25 31...
				threeNumbersString+=numbers3[tmp2/10]+" "+numbers1[tmp2%10];
			}else if (tmp2/10==1&&tmp2%10!=0) {
				threeNumbersString=threeNumbersString+numbers2[tmp2%10];
			}
			}	
		}else if (threeNumString.length()==1&&threeNum!=0) {
			threeNumbersString=threeNumbersString+numbers1[tmp2%10];
		 }else if (threeNumString.length()==1&&threeNum==0) {
			 threeNumbersString="";
		}		
		return threeNumbersString;
	}
}
