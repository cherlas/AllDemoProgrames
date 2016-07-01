package Demoes.unsucceed;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Yogurt on 16/7/1.
 * 超时
 */
public class POJ_1002_487_3279 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] num=new char[200];
        num['A']=num['B']=num['C']='2';
        num['D']=num['E']=num['F']='3';
        num['G']=num['H']=num['I']='4';
        num['J']=num['K']=num['L']='5';
        num['M']=num['N']=num['O']='6';
        num['P']=num['R']=num['S']='7';
        num['T']=num['U']=num['V']='8';
        num['W']=num['X']=num['Y']='9';
        Map<String ,Integer> res=new TreeMap<String,Integer>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String str=sc.nextLine();
            str=str.replaceAll("-","");
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                if(j==3) sb.append("-");
                if(c>='A'&&c<='Z')
                    sb.append(num[c]);
                else if(c>='0'&&c<='9') sb.append(str.charAt(j));
            }
            if(res.containsKey(sb.toString())) {
                int ns=res.get(sb.toString())+1;
                res.remove(sb.toString());
                res.put(sb.toString(), ns);
            }else
                res.put(sb.toString(),1);
        }
        boolean flag=false;
        for(String str:res.keySet()){
            if (res.get(str)!=1) {
                System.out.println(str + " " + res.get(str));
                flag=true;
            }
        }
        if (!flag) System.out.println("No duplicates.");
    }

}
