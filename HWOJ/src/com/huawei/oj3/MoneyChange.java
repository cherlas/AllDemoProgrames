package com.huawei.oj3;
import java.util.Scanner;

public class MoneyChange {
	
	private static Scanner sc;
	private static double money;
	private static String[] numbers=new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
	private static String[] bigNumbers=new String[]{"佰","仟","万","亿"};
	private static String[] unit=new String[]{"元","角","分"};
	private static String zheng="整";
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		money=sc.nextDouble();
		parseMoney();
	}
private static void parseMoney(){
	
	String str="人民币";
	long money1=(long)money; //整数
	double money2=money-money1; //小数
	
	str+=read(money1);
  }

private static String read(long moneyz) {
	String moneyString=String.valueOf(moneyz);
	String changeMoney;
	if (moneyString.length()==1) {
		changeMoney=numbers[(int)moneyz%10];
	}else if (moneyString.length()==2) {
		if((int)moneyz/10==1){
			changeMoney=numbers[10]+numbers[(int)moneyz%10];
		}
	}
	
	
	
	
	return null;
 }
}
