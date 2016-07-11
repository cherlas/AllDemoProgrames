package AllDemoes.Important;

import java.util.*;

/**
 * Created by Yogurt on 16/7/10.
 */
public class HDU1863畅通工程_prim_kruskal {
    private static int roadN,villageM;
    private static int[][] graph;
    private static class Edge implements Comparable{
        int from;
        int to;
        int cost;
        public Edge(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Object o) {
            Edge edge=(Edge)o;
            if (this.cost>=edge.cost) return 1;
            else return -1;
        }
    }
    private static Queue<Edge> edges=new PriorityQueue<>();//所有边

    private static Queue<Edge> primQueue=new ArrayDeque<>();

    private static List<Edge> primMst =new LinkedList<>();

    private static List<Edge> kruskalMst =new LinkedList<>();

    private static int[] id;

    private static boolean[] used;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        roadN=sc.nextInt();
        while (roadN!=0){

            edges.clear();
            primMst.clear();
            primQueue.clear();
            kruskalMst.clear();

            villageM=sc.nextInt();

            used=new boolean[villageM+1];
            for(int i=0;i<=villageM;i++)
                used[i]=false;

            graph=new int[villageM+1][villageM+1];
            id=new int[villageM+1];
            for(int i=0;i<roadN;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                graph[a][b]=graph[b][a]=c;
                edges.add(new Edge(a,b,c));
            }
            int prim=Prim();
            int kruskal=kruskal();
            if (prim==0||kruskal==0) System.out.println("?");
            else {
                System.out.println(prim);
                System.out.println(kruskal);
            }

            roadN=sc.nextInt();
        }
    }

    private static int Prim() {// 点
        int countSum=0;
        visit(1);

        while (!primQueue.isEmpty()){
            Edge edge=primQueue.poll();
            int from=edge.from;
            int to=edge.to;
            int cost=edge.cost;
            if (used[from]&&used[to]) continue;
            primMst.add(edge);
            countSum+=cost;
            if (!used[from]) visit(from);
            if (!used[to]) visit(to);

        }
        if (primMst.size()!=villageM-1) return 0;
        return countSum;
    }

    private static void visit(int v) {
        used[v]=true;
        for (int i=1;i<=villageM;i++)
            if (!used[i]&&graph[v][i]!=0) primQueue.add(new Edge(v,i,graph[v][i]));
    }

    private static int kruskal() { //边
        for (int i=0;i<=villageM;i++)
            id[i]=i;
        int countSum=0;
        for (int i=0;i<edges.size();i++){
            Edge edge=edges.poll();
            int from=edge.from;
            int to=edge.to;
            int cost=edge.cost;
            if (!same(from,to)){
                union(from,to);
                kruskalMst.add(edge);
                countSum+=cost;
            }
        }

        if (kruskalMst.size()!=villageM-1) return 0;
        return countSum;
    }

    private static void union(int from, int to) {
        int fromId=find(from);
        int toId=find(to);
        for (int i=1;i<=villageM;i++)
            if (id[i]==toId) id[i]=fromId;
    }

    private static boolean same(int from, int to) {
        return find(from)==find(to);
    }

    private static int find(int v) {
        return id[v];
    }
}
