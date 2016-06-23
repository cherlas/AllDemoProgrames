package AllDemoes;

/**
 * Created by Yogurt on 6/22/16.
 */
import java.util.Scanner;
public class 字符个数统计 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;
        boolean[] book=new boolean[128];
        for (int i=0;i<128;i++) book[i]=false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 0 && c < 127&&!book[c]) {
                sum++;
                book[c]=true;
            }
        } System.out.println(sum);
    }
}
