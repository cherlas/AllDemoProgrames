package AllDemoes;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 整数转化 {


    public int calcCost(int A, int B) {
        // write code here
        if(A<B){
            int t=A;
            A=B;
            B=t;
        }
        String strA=Integer.toBinaryString(A);
        String strB=Integer.toBinaryString(B);
        while(strB.length()!=strA.length())
            strB="0"+strB;
        int count =0;
        for(int i=0;i<strA.length();i++)
            if(strA.charAt(i)!=strB.charAt(i))
                count++;
        return count;
    }
}
