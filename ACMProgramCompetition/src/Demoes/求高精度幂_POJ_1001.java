package Demoes;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/1.
 */
public class 求高精度幂_POJ_1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigDecimal bg = new BigDecimal(sc.next());
            int n = sc.nextInt();
            String res = bg.pow(n).stripTrailingZeros().toPlainString();
            if (res.startsWith("0") && !res.equals("0")) System.out.println(res.substring(1));
            else System.out.println(res);
        }
    }
}
