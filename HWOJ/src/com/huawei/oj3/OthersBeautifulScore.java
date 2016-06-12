package com.huawei.oj3;

import java.util.Arrays;
import java.util.Scanner;
public class OthersBeautifulScore {
 private static Scanner sca;

public static void main(String[] args) {
  
  sca = new Scanner(System.in);
  int n=sca.nextInt();
  sca.nextLine();
  
  int flag,len=0;
  int start,end;
  
  int count[];      //  统计名字每个字母的个数
  int sum[]=new int[n];  //每个name的“漂亮度”
  char s[];     //name
  for(int i=0; i<n; i++){
   s = sca.nextLine().toLowerCase().toCharArray();
   Arrays.sort(s);
   
   len =s.length;
   flag=0; start=0; end=0;
   
   count=new int[len];
   while(end<len){    //  统计排序后名字每个字母的个数
    while(end<len&&s[start]==s[end]) end++;
    count[flag++]=end-start;
    start=end;   
   }
   Arrays.sort(count);   //  个数最多的字母=26，依次递减
   for(int j=len-1; j>0&&count[j]!=0;j--)
    sum[i]+=(26+j-len+1)*count[j];
  }
  for(int i=0; i<n; i++) 
   System.out.println(sum[i]);
 }
}