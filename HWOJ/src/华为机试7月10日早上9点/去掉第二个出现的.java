package 华为机试7月10日早上9点;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 去掉第二个出现的 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String strA=sc.nextLine();
        String strB=sc.nextLine();
        for (int i=0;i<strB.length();i++){
            char c=strB.charAt(i);
            if (strA.contains(c+"")){
                strA=strA.replaceAll(c+"","");
            }
        }
        System.out.println(strA);
    }
}
