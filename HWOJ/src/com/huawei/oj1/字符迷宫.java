package com.huawei.oj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;

public class 字符迷宫 {
		
	public static char[][] strings;
	public static boolean[][] isVisited;
	private static String word;
	static int n,m,s=0;
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str=br.readLine();
		String[] mn=str.split(" ");
		n=Integer.parseInt(mn[0]);
		m=Integer.parseInt(mn[1]);
		while(n<0||m>=21){
			System.out.println("输入错误,n>0,m<21");
			System.exit(0);
		}
		strings=new char[n][m];
		isVisited=new boolean[n][m];
		str=br.readLine();
		while(str==null||str.length()>100) {
			System.out.println("输入正确的单词");
		}
		word=str;
		int flag=0;
		char[] b=new char[m];
			while((flag<n)){//((str=br.readLine())!=null)&&
				str=br.readLine();
				if (str.length()<m) {
					System.out.println("字符串长度错误");
					continue;
				}
				b=str.toCharArray();
				strings[flag]=b;
				flag++;
			}
//			if (flag<n) {
//				System.out.println("字符串个数错误");
//			}
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					isVisited[i][j]=false;
				}
			}
		字符迷宫 wordMaze=new 字符迷宫();
		for (int i = 0; i < n; i++) {
			for(int j=0;j<m;j++){
				if (strings[i][j]==word.charAt(s)) 
				{	
					//System.out.print("("+i+","+j+")-->");
					isVisited[i][j]=true;
					s++;
					wordMaze.find(i,j);
				}
				if (i==n-1&&j==m-1&&s!=word.length()) {
					System.out.println("NO");
				}
				}
			
		}
	}
	
	public void find(int i,int j){
				if (s==word.length()) {
					System.out.println("Yes");
					System.exit(0);
				}
					int s1=i,s2=j;
					while((Directsearch(s1,s2,s)!=0)&&(s1!=i)&&(s2!=j)){
						s++;
						switch (Directsearch(s1, s2, s)) {
						case 1:
							find(i-1,j);
							s--;
							break;
						case 2:
							find(i+1, j);
							s--;
							break;
						case 3:
							find(i, j-1);
							s--;
							break;
						case 4:
							find(i, j+1);
							s--;
							break;
						default:
							break;
						}
						
					}
					s--;
				}
	
	int Directsearch(int i,int j,int s){
		   if ((i>=1)&&(strings[i-1][j]==word.charAt(s))&&(isVisited[i-1][j]==false)) {
			   
			return 1;
		}else if((i<n-1)&&(strings[i+1][j]==word.charAt(s))&&(isVisited[i+1][j]==false)) {
			return 2;
		}else if ((j>=1)&&(strings[i][j-1]==word.charAt(s))&&(isVisited[i][j-1]==false)) {
			return 3;
		}else if ((j<m-1)&&(strings[i][j+1]==word.charAt(s))&&(isVisited[i][j+1]==false)) {
			return 4;
		}
		return 0;
	}

}
