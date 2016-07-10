package 华为机试7月10日下午1点;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 去重复单词和标点符号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        StringBuffer res = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                sb.append(c);
            else {
                if (!list.contains(sb.toString())) {
                    list.add(sb.toString());
                }
                sb = new StringBuffer();
            }
        }
        if (!list.contains(sb.toString()))
            list.add(sb.toString());
        for (int j = 0; j < list.size(); j++) {
            res.append(list.get(j));
            if (j != list.size() - 1)
                res.append(" ");
        }System.out.println(res);
    }
}
