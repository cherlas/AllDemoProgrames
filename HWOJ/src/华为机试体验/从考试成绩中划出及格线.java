package 华为机试体验;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yogurt on 16/7/7.
 */
public class 从考试成绩中划出及格线 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] data=new int[10];
        for(int i=0;i<10;i++)
            data[i]=sc.nextInt();
        Arrays.sort(data);
        int score;
        if (data[0]>=60) score=60;
        else score=data[4]/10*10;
        System.out.println(score);
    }
}
