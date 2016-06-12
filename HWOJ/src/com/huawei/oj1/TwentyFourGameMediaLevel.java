package com.huawei.oj1;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TwentyFourGameMediaLevel {
	private static Scanner sc;
	private static String calSymbol="+-*/";
	public static void main(String[] args) throws ScriptException {
		sc=new Scanner(System.in);
		String inputData=sc.nextLine();
		if (inputData.contains("joker")||inputData.contains("JOKER")) {
			System.out.println("ERROR");
		}else {
			StringBuffer sb=new StringBuffer(inputData);
			for(int i=0;i<sb.length();i++){
				if (sb.charAt(i)=='A') {
					sb.replace(i,i+1 , "1");
				}else if (sb.charAt(i)=='J') {
					sb.replace(i,i+1 , "11");
				}else if (sb.charAt(i)=='Q') {
					sb.replace(i,i+1 , "12");
				}if (sb.charAt(i)=='K') {
					sb.replace(i,i+1 , "13");
				}
			}
			inputData=sb.toString();
			String[] numbers=inputData.split(" ");
			boolean flag=false;
			String result="";
			outer:
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					for(int k=0;k<4;k++){
						String str=""+numbers[0]+calSymbol.charAt(i)+numbers[1]+calSymbol.charAt(j)
						+numbers[2]+calSymbol.charAt(k)+numbers[3];
						ScriptEngineManager manager=new ScriptEngineManager();
						ScriptEngine engin=manager.getEngineByName("JavaScript");
						Object object=engin.eval(str);
						double d=Double.parseDouble(object.toString());
						if (d==24) {
							flag=true;
							result=str;
							break outer;
						}
					}
				}
			}
			if (flag) {
				System.out.println(result);
			}else {
				System.out.println("NONE");
			}
		}
	}
}
