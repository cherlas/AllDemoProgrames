package AllDemoes.Important;

import java.util.*;

/**
 * Created by Yogurt on 16/7/6.
 */
public class 简单错误记录 {
    private static class Error implements Comparable{
        String name;
        int num;
        public Error(String name,int num){
            this.num=num;
            this.name=name;
        }
        @Override
        public int compareTo(Object o) {
            Error error=(Error)o;
            if (this.num>error.num) return -1;
            else if (this.num==num) return 1;
            else return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<100;i++){
            String err=sc.nextLine();
            int a=err.lastIndexOf('\\');
            int b=err.lastIndexOf(" ");
            String na=err.substring(a+1,b);
            if (na.length()>16) na=na.substring(na.length()-16)+err.substring(b);
            else na=na+err.substring(b);
            if (map.containsKey(na)){
                int t=map.get(na);
                t++;
                map.put(na,t);
            }else {
                map.put(na,1);
            }
        }
        Set<Error> set=new TreeSet<>();
        for(String str:map.keySet()){
            set.add(new Error(str,map.get(str)));
            System.out.println(str+" "+map.get(str));
        }
        System.out.println();
        int n=0;
        for(Error error:set){
            System.out.println(error.name+" "+error.num);
            n++;
            if (n==8) break;
        }
    }
}
