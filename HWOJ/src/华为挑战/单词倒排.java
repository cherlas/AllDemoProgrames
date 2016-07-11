package 华为挑战;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/11.
 */
public class 单词倒排 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if (c>='A'&&c<='Z'||c>='a'&&c<='z')
                sb.append(c);
            else if (c=='-') {
                if (i+1<str.length()&&str.charAt(i+1)=='-'){
                    while (i<str.length()&&str.charAt(i)=='-') i++;
                    sb.append(" ");
                    if (i==str.length()) break;
                    i--;
                }else {
                    sb.append("-");
                }
            }
            else sb.append(" ");
        }
        String[] res=sb.toString().split(" ");
        sb=new StringBuffer();
        for (int i=res.length-1;i>=0;i--){
            sb.append(res[i]);
            if (i!=0) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
