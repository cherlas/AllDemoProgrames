package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/6.
 */
public class 数独 {
    private static int[][] sukudo=new int[9][9];
    private static boolean isTrue=false;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                sukudo[i][j]=sc.nextInt();
        solve();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sukudo[i][j]);
                if (j!=8) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean solve() {
        if (isTrue) return true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if (sukudo[i][j]==0){
                    for(int k=1;k<=9;k++){
                        if (isValid(i,j,k)){
                            sukudo[i][j]=k;
                            if (solve()) {
                                isTrue = true;
                                return true;
                            }
                        }
                        sukudo[i][j]=0;
                    }
                   return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y, int k) {
        for(int i=0;i<9;i++)
            if (sukudo[x][i]==k) return false;
        for(int i=0;i<9;i++)
            if (sukudo[i][y]==k) return false;
        int x1=x/3*3;
        int y1=y/3*3;
        for(int i=x1;i<x1+3;i++)
            for(int j=y1;j<y1+3;j++){
                if (x1==x&&y1==y) continue;
                if (sukudo[i][j]==k) return false;
            }
        return true;
    }
}
