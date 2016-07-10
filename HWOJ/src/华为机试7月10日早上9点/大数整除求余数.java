package 华为机试7月10日早上9点;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 大数整除求余数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BigDecimal a=new BigDecimal(sc.nextLine());
        BigDecimal b=new BigDecimal(sc.nextLine());
        BigDecimal[] res=a.divideAndRemainder(b);
        System.out.println(res[1].toString());
    }
}
