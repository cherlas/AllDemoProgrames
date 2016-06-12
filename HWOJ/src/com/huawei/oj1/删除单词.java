package com.huawei.oj1;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import java.util.Scanner;  
import java.util.TreeMap;  
  
public class 删除单词{  
    private static Scanner sc;  
    private static int numOfWords,order;  
    private static String dealWord;  
    private static Map<String,Integer> map=new TreeMap<>();  
    public static void main(String[] args) {  
        sc=new Scanner(System.in);  
        numOfWords=sc.nextInt();  
        for (int i = 0; i <numOfWords; i++) {  
            String string=sc.next();  
            map.put(string, new Integer(1));  
        }  
          
        dealWord=sc.next();  
        order=sc.nextInt();  
        List<String> list=new ArrayList<>();  
        for(String string:map.keySet()){ 
        	//System.out.println(string);
            boolean flag=true;  
            if (string.length()!=dealWord.length()) {  
                flag=false;  
            }else {  
                for(int i=0;i<string.length();i++){  
                    if (!(dealWord.contains(string.charAt(i)+"")) || ! string.contains(dealWord.charAt(i)+"") ) {  
                        flag=false;  
                    }  
                }  
            }  
            if (flag&&!string.equals(dealWord)) {  
                list.add(string);  
            }  
        }  
        System.out.println(list.size());  
        if (!list.isEmpty()) {  
            System.out.println(list.get(order-1));  
        }  
    }  
}  