package AllDemoes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/9.
 */
public class 单词接龙 {
    private static int n;
    private static String[] words;
    private static int[][] directedGraph;
    private static int[] inDegree,outDegree;
    private static boolean[] hasLetter;
    private static boolean isEulerPath,isEulerCicuit,hasEuler=true;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        directedGraph=new int[26][26];
        inDegree=new int[26];
        outDegree=new int[26];
        hasLetter=new boolean[26];
        words=new String[n];
        for (int i=0;i<n;i++)
            words[i]=sc.next();
        System.out.println(canArrangeWords());
    }

    private static String canArrangeWords() {
        for(int i=0;i<n;i++){
            char firstLetter=words[i].charAt(0);
            char lastLetter=words[i].charAt(words[i].length()-1);
            directedGraph[firstLetter-'a'][lastLetter-'a']=1;
            outDegree[firstLetter-'a']++;
            inDegree[lastLetter-'a']++;
            hasLetter[firstLetter-'a']=true;
            hasLetter[lastLetter-'a']=true;
        }
        int startNum=0,endNum=0;
        for (int i=0;i<26;i++){
            if (outDegree[i]-inDegree[i]==1)
                startNum++;
            if (inDegree[i]-outDegree[i]==1)
                endNum++;
            if (Math.abs(inDegree[i]-outDegree[i])>1){
                hasEuler=false;
                break;
            }
        }
        isEulerPath=(startNum==1)&&(endNum==1);//欧拉路径
        isEulerCicuit=(startNum==0)&&(endNum==0);//欧拉回路
        if (!isEulerCicuit&&!isEulerPath)
            hasEuler=false;
        //连通性  弱连通
        int vertexNum=0;
        for (int letter=0;letter<26;letter++)
            if (hasLetter[letter])
                vertexNum++;
        int firstWordFirstLetter=words[0].charAt(0)-'a';
        hasEuler=hasEuler&&isConnected(firstWordFirstLetter,vertexNum);
        if (hasEuler)
            return "Yes";
        else
            return "No";
    }

    private static boolean isConnected(int start, int vertexNum) {
        int[][] unDirectedGraph=new int[26][26];
        for (int i=0;i<26;i++)
            for (int j=0;j<26;j++)
                if (directedGraph[i][j]==1){
                    unDirectedGraph[i][j]=1;
                    unDirectedGraph[j][i]=1;
                }
        Queue<Integer> queue=new LinkedList<>();
        boolean[] isPassed=new boolean[26];
        int passVertex=0;
        queue.add(start);
        while (!queue.isEmpty()){
            int currentVertex=queue.poll();
            isPassed[currentVertex]=true;

            for (int i=0;i<26;i++){
                if (unDirectedGraph[currentVertex][i]==1&&!isPassed[i]){
                    unDirectedGraph[currentVertex][i]=0;
                    unDirectedGraph[i][currentVertex]=0;
                    queue.add(i);
                }
            }
        }
        for (int i=0;i<26;i++)
            if (isPassed[i])
                passVertex++;
        if (passVertex==vertexNum) return true;
        return false;
    }
}
