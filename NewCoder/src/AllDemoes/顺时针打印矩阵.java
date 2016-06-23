package AllDemoes;

import java.util.Scanner;

/**
 * Created by Yogurt on 6/19/16.
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 测试样例：
 [[1,2],[3,4]],2,2
 返回：[1,2,4,3]
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                mat[i][j]=sc.nextInt();
        clockwisePrint(mat,n,m);

    }
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] result=new int[n*m];
        int up=0,down=n-1,left=0,right=m-1,index=0;
        while(index!=m*n-1){
            for(int i=left;i<=right;i++) { //上侧
                result[index] = mat[up][i];
                index++;
            }
            up++;
            if(index>n*m-1) break;
            for(int i=up;i<=down;i++){ //右侧
                result[index]=mat[i][right];
                index++;
            }
            right--;
            if(index>n*m-1) break;
            for(int i=right;i>=left;i--){ //下面
                result[index]=mat[down][i];
                index++;
            }
            down--;
            if(index>n*m-1) break;
            for(int i=down;i>=up;i--) {//左侧
                result[index]=mat[i][left];
                index++;
            }
            left++;
            if(index>n*m-1) break;
        }
        return result;
    }
}
