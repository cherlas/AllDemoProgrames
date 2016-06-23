package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。
 测试样例：
      [[1,2,3],[4,5,6],[7,8,9]],3
 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class 顺时针旋转矩阵 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                mat[i][j]=sc.nextInt();
        rotateMatrix(mat,n);

    }

    public static int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] s=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                s[j][n-i-1]=mat[i][j];
            }
        return s;
    }
}
