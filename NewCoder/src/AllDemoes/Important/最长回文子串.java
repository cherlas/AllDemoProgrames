package AllDemoes.Important;

import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/8.
 */
public class 最长回文子串 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
        System.out.println(getLongestPalindrome(str,n));

    }

    private static int getLongestPalindrome(String A, int n) {

        if(n==1||n==0) return n;
        int[][] c=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=i+2;j<n;j++)
                c[i][j]=0;
        for(int i=0;i<n-1;i++){
            c[i][i]=1;
            if(A.charAt(i)==A.charAt(i+1))
                c[i][i+1]=1;
        }
        int longest=0,begin=0;
        //String longestStr="";
        for(int i=3;i<=n;i++){ //长度
            for(int j=0;i+j-1<n;j++){ //起点
                if(A.charAt(j)==A.charAt(j+i-1)){
                    c[j][j+i-1]=c[j+1][j+i-2];
                    if(c[j][j+i-1]!=0){
                        //longest=Math.max(j-i+1,longest);
                        if (i>longest){
                            longest=i;
                            //begin=j;
                           // longestStr=A.substring(j,j+i);
                        }
                    }
                }else {
                    c[j][j+i-1]=0;
                }
            }
        }
//        for(int i=0;i<n;i++){
//            for (int j=0;j<n;j++)
//                System.out.print(c[i][j]+" ");
//            System.out.println();
//        }
        //System.out.println(begin+" "+longestStr+"  "+longest);
        return longest;
    }

}
