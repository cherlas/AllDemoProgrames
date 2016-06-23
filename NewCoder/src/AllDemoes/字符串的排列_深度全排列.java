package AllDemoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 字符串的排列_深度全排列 {
    static boolean[] book;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        ArrayList<String> res=Permutation(str);
        for(String s:res){
            System.out.println(s);
        }
    }

    public static ArrayList<String> Permutation(String str) {
        if(str.equals("")) return new ArrayList<>();
        char[] st=str.toCharArray();
        Arrays.sort(st);
        book=new boolean[str.length()];
        for(int i=0;i<str.length();i++)
            book[i]=false;
        ArrayList<String> result=new ArrayList<>();
        char[] r=new char[str.length()];
        dfs(st,r,0,result);
        return  result;
    }
    public static void dfs(char[] a,char[] r,int step,ArrayList<String> res){
        if(step==a.length){
            //System.out.println("succeed");
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<a.length;i++)
                sb.append(r[i]);
            if(!res.contains(sb.toString())) //!!!!去重复
                res.add(sb.toString());
            return;
        }
        for(int i=0;i<a.length;i++){
            if(!book[i]){
                book[i]=true;
                r[step]=a[i];
                dfs(a,r,step+1,res);
                book[i]=false;
            }
        }
        return;
    }
}
