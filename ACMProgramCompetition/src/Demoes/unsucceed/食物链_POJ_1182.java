package Demoes.unsucceed;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/1.
 * //超时
 */
public class 食物链_POJ_1182 {
    private static int n,k;
    private static class Dxy{
        int d;
        int x;
        int y;
        public Dxy(int d,int x,int y){
            this.d=d;
            this.x=x;
            this.y=y;
        }
    }
    private static Dxy[] dxies;
    private static int[] par,rank;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        par=new int[n*3];
        rank=new int[n*3];
        init(n*3);
        int ans = 0;
        dxies=new Dxy[k];
        for(int i=0;i<k;i++){
            dxies[i]=new Dxy(sc.nextInt(),sc.nextInt(),sc.nextInt());
            int t=dxies[i].d;
            int x=dxies[i].x-1;
            int y=dxies[i].y-1;
            if(x<0||x>=n||y<0||y>=n){
                ans++;
                continue;
            }
            if(t==1){
                if(same(x,y+n)||same(x,y+2*n)){
                    ans++;
                }else {
                    unit(x,y);
                    unit(x+n,y+n);
                    unit(x+2*n,y+2*n);
                }
            }else {
                if(same(x,y)||same(x,y+2*n)){
                    ans++;
                }else {
                    unit(x,y+n);
                    unit(x+n,y+2*n);
                    unit(x+2*n,y);
                }
            }
        }
        System.out.println(ans);
    }

    private static void unit(int x, int y) {
        x=find(x);
        y=find(y);
        if(x==y) return;
        if(rank[x]<rank[y]){
            par[x]=y;//x的父节点是y
        }else {
            par[y]=x;
            if (rank[x]==rank[y]) rank[x]++;
        }
    }

    private static boolean same(int x, int y) {
        return find(x)==find(y);
    }

    private static int find(int x) {
        if(par[x]==x) return x;
        else return par[x]=find(par[x]);
    }

    private static void init(int s) {
        for(int i=0;i<s;i++){
            par[i]=i;
            rank[i]=0;
        }
    }

}
