package AllDemoes;

import java.util.*;

/**
 * Created by Yogurt on 6/21/16.
 */
public class 偶数大翻转 {
    private static int[] inputs;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            inputs = new int[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = sc.nextInt();
                if (inputs[i] % 2 == 0)
                    inputs[i] = reverse(inputs[i]);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(inputs[i]);
                if (i != n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int reverse(int input) {
        String str=Integer.toBinaryString(input);
        StringBuilder sb=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
            sb.append(str.charAt(i));
        return Integer.parseInt(sb.toString(),2);
    }
}
