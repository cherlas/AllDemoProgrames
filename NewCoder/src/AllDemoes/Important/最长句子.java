package AllDemoes.Important;

import java.util.*;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 最长句子 {
    private static int[][] graph;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();
            Map<String,Set<String>> map=new LinkedHashMap<>();
            Map<String,Integer> hasFind=new HashMap<>();
            int max=0;
            if (n!=0){
                for (int i=0;i<n;i++){
                    String strA=sc.next();
                    String strB=sc.next();
                    if (map.containsKey(strA)){
                        Set<String> strings=map.get(strA);
                        strings.add(strB);
                        map.put(strA,strings);
                    }else {
                        Set<String> strings=new HashSet<>();
                        strings.add(strB);
                        map.put(strA,strings);
                    }
                }
                int len;
                for (String str:map.keySet())
                    if ((len=getLongestPath(str,map,hasFind))>max)
                        max=len;
            }
            System.out.println(max);
        }
        sc.close();
    }

    private static int getLongestPath(String s,Map<String,Set<String>> map,Map<String,Integer> hasFind) {
        Set<String> set=map.get(s);
        if (set==null) return 1;
        if (hasFind.containsKey(s)) return hasFind.get(s);
        int max=0;
        for (String str:set){
            int len=1+getLongestPath(str,map,hasFind);
            if (len>max) max=len;
        }
        hasFind.put(s,max);
        return max;
    }
}
