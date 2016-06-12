package com.huawei.oj1;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class 表达式求值 {
	private static Scanner sc;
	static String str;
	public static void main(String[] args) throws ScriptException {
		sc=new Scanner(System.in);
		str=sc.nextLine();
		boolean isCalculated=calculate(str);
		if (isCalculated) {
			System.out.println(getResult()+" "+"true");
		}else {
			System.out.println("false");
		}
	}
	/*
    功能: 对输入的字符串表达式进行求值计算，并输出结果。
 
    输入:String inputString：表达式字符串   
         
    返回: int ：正常返回true，失败返回false
    */
    public static boolean calculate(String inputString){
    	String string="0123456789+-*/()";
    	int tmp1=0,tmp2=0;
        for(int i=0;i<inputString.length();i++){
        	char c=inputString.charAt(i);
        	if (!string.contains(c+"")) {
				return false;
			}
        	if (c=='(') {
				tmp1++;
			}
        	if (c==')') {
				tmp2++;
			}
        }
        if (tmp1!=tmp2) {
			return false;
		}
       return true;
    }
 
    /*获取计算结果（int型）*/
    public static int getResult() throws ScriptException{
    	StringBuffer sb=new StringBuffer(str);
        int a1=sb.lastIndexOf("(");
        int a2=sb.indexOf(")",a1);
        while(a1!=-1){
        	sb.replace(a1, a2+1, doThing(sb.substring(a1+1,a2)));
        	a1=sb.lastIndexOf("(");
        	a2=sb.indexOf(")",a1);
        }
       return (int)Double.parseDouble(doThing(sb.toString()));
    }
    
   public static String doThing(String str1) throws ScriptException {
	   ScriptEngineManager manager=new ScriptEngineManager();
	   ScriptEngine engine=manager.getEngineByName("JavaScript");
	   Object object=engine.eval(str1);
	   return object.toString();
}
}
