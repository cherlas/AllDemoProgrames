package com.huawei.oj3;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateChar {
	private static Scanner sc;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		char[] originalString=sc.nextLine().toCharArray();
		Arrays.sort(originalString);
		calculateChar(originalString);

	}
private static void calculateChar(char[] cs) {
		int k=0,flag=1;
		
		int[] num=new int[cs.length];
		char[] singleChar=new char[cs.length];
		for(int i=0;cs[i]!='\0';){
			if((cs[i]>='0'&&cs[i]<='9')||(cs[i]>='a'&&cs[i]<='z')||(cs[i]>='A'&&cs[i]<='Z')||cs[i]==' '){
			singleChar[k]=cs[i];
			flag=0;
			char c=cs[i];
			i++;
			while(i<cs.length&&cs[i]==c) 
				{
				i++;			
				flag++;
				}
			num[k]=flag;
			k++;
		}else {
			i++;
			continue;
			}
		}
		for(int i=0;i<k;i++){
			for(int j=i;j<k;j++){
				if(num[i]==num[j]){
					if (singleChar[i]>singleChar[j]) {
						swap(num, singleChar, i, j);
					}
				}else if(num[i]<num[j])
					swap(num,singleChar,i,j);
			}
		}	
		System.out.println(singleChar);
}

private static void swap(int[] num,char[] singlechar,int i,int j) {
		int tmp=num[i];
		num[i]=num[j];
		num[j]=tmp;
		char tmp1=singlechar[i];
		singlechar[i]=singlechar[j];
		singlechar[j]=tmp1;
	}
}
