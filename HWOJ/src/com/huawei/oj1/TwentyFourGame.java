package com.huawei.oj1;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TwentyFourGame {
	private static Scanner sc;
	public static void main(String[] args) throws ScriptException {
		sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		String strings="+-*/";
		String expression="";
		boolean flag=false;
		outer:
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
				expression=""+a+strings.charAt(i)+b+strings.charAt(j)+c+strings.charAt(k)+d;
				ScriptEngineManager manager=new ScriptEngineManager();
				ScriptEngine engine=manager.getEngineByName("JavaScript");
				Object object=engine.eval(expression);
				double s=Double.parseDouble(object.toString());
				if(s==24){
					flag=true;
					System.out.println("true");
					break outer;
				}
				}
			}
		}
		if (!flag) {
			System.out.println("false");
		}
	}	
}
