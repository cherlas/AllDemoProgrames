package 一站通Offer;

import java.util.*;
public class 字符串反转 {
    private static Scanner sc;
    public static void main(String[] args){
    	sc=new Scanner(System.in);
    	String inString;
    	while(sc.hasNextLine()){
            inString=sc.nextLine();
            System.out.println(trans(inString.substring(0,inString.indexOf(",")),Integer.parseInt(inString.substring(inString.indexOf(",")+1))));
            }
    }
    
    public static String trans(String s, int n) {
        // write code here     
	        StringBuffer sb=new StringBuffer(),sb1=new StringBuffer();
	        for(int i=0;i<s.length();i++){	        	
	        		char c=s.charAt(i);
	        		if (c>='a'&&c<='z') {
	        			sb.append((char)(c-32));
					}else if (c>='A'&&c<='Z') {
						sb.append((char)(c+32));
                    }else {
						sb.append(c);
					}
	        	}
	        String[] strings=sb.toString().split(" ");
	        	for(int i=strings.length-1;i>=0;i--){
	        		sb1.append(strings[i]);
	        		if (i!=0) {
						sb1.append(" ");
					}
	        	}
	        
			return sb1.toString();
    }
}
