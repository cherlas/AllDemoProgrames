package 华为机试7月10日下午1点;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
2
dsafsadfadf
fdfd
aaaaaaaa
bbbbbbbb
*/
public class A变为B的最小费用 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++){

            String A=sc.nextLine();
            String B=sc.nextLine();
            int min=Integer.MAX_VALUE;
            if (A.startsWith(B)||A.endsWith(B)) System.out.println(2);
            else if (A.contains(B)) System.out.println(4);
            else if(B.startsWith(A)||B.endsWith(A)) System.out.println(B.length()-A.length()+2);
            else {
                for (int len=B.length();len>0;len--){
                    String subs=B.substring(0,len);
                    String sube=B.substring(B.length()-len,B.length());
                    //System.out.println(sube+"  "+subs);
                    if (A.startsWith(subs)||A.endsWith(subs)||A.startsWith(sube)||A.endsWith(sube)){
                        min=2+B.length()-len+2;
                        break;
                    }else if (A.contains(subs)||A.contains(sube)){
                        min=4+B.length()-len+2;
                        break;
                    }
                }

                min=Math.min(min,4+B.length());
            }
            System.out.println(min);
        }
    }
}
