package com.huawei.oj1;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class 四则运算 {
	private static Scanner sc;
	public static void main(String[] args) throws ScriptException {
		sc=new Scanner(System.in);
		StringBuffer input=new StringBuffer(sc.nextLine());
		String str1="+-",str2="--",str3="-+";
		for(int i=0;i<input.length()-1;i++){
			if (input.substring(i, i+2).equals(str1)) {
				input.replace(i, i+2, "-");
			}else if (input.substring(i, i+2).equals(str2)) {
				input.replace(i, i+2, "+");
			}else if (input.substring(i, i+2).equals(str3)) {
				input.replace(i, i+2, "-");
			}
		}
		String string="()[]{}";
		for(int i=0;i<string.length();i+=2){
			int a1=input.lastIndexOf(string.charAt(i)+"");
			int a2=input.indexOf(string.charAt(i+1)+"",a1);
			while(a1!=-1){
				input.replace(a1, a2+1, calculate(input.substring(a1+1,a2)));
				a1=input.lastIndexOf(string.charAt(i)+"");
				a2=input.indexOf(string.charAt(i+1)+"",a1);
			}
		}
			System.out.println((int)Double.parseDouble(calculate(input.toString())));	

	}
private static String calculate(String str) throws ScriptException {
	ScriptEngineManager manger=new ScriptEngineManager();
	ScriptEngine engine=manger.getEngineByName("JavaScript");
	Object object=engine.eval(str);
	return object.toString();
}
}
