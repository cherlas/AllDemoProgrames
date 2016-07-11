package 华为挑战;

import java.util.Scanner;


public class 内存分配 {
	private static Scanner sc;
	private static class Memory{
		int sta;
	}
    private static int poolSize;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		poolSize=sc.nextInt();
		int flag =1;
		while(sc.hasNext()){
			int input=sc.nextInt();
			if(input<flag){
				freeMem(input);
			}else {
				memAlloc(input,flag,1);
				flag++;
			}
		}
		
		
	}

private static void freeMem(int freeNum) {

	}

private static void memAlloc(int allocMem,int flag,int start) {

  }
}
