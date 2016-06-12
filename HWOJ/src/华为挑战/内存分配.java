package 华为挑战;

import java.util.Scanner;


public class 内存分配 {
	private static Scanner sc;
	private static StringBuffer memoryAddress;
	private static int poolSize;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		poolSize=sc.nextInt();
		memInit();
		int flag =1;
		while(sc.hasNext()){
			int input=sc.nextInt();
			if(input<flag){
				freeMem(input);
			}else {
				memAlloc(input,flag,memoryAddress.indexOf("a"));
				flag++;
			}
		}
		
		
	}
private static void memInit(){
	String string="";
	for(int i=0;i<poolSize;i++){
		string=string+'a';
	}
	memoryAddress=new StringBuffer(string);
}

private static void freeMem(int freeNum) {
	String string ="";
	for(int i=memoryAddress.indexOf(freeNum+"");i<=memoryAddress.lastIndexOf(freeNum+"");i++){
		string+='a';
	}
	memoryAddress.replace(memoryAddress.indexOf(freeNum+""), memoryAddress.lastIndexOf(freeNum+"")+1, string);
	System.out.println(string.length());
	}

private static void memAlloc(int allocMem,int flag,int start) {
	if (start==-1) {
		return ;
	}
	int end=start;
	String string="";
	for(int i=0;i<allocMem;i++){
		string=string+flag;
	}
	boolean isVec=false;
	System.out.println(start);
	while(end<poolSize&&memoryAddress.charAt(end)=='a') {
		end++;
		if(end-start+1>=allocMem){
		memoryAddress.replace(start, start+allocMem, string);
		isVec=true;
		break;
		}
	}
	if (start==-1) {
		System.out.println("alloc mem fail!");
		System.exit(0);
	}
	if(!isVec&&end<poolSize) {System.err.println(end);
		memAlloc(allocMem, flag, memoryAddress.indexOf("a", end));
		return;
		}
	if (isVec) {
		if (!sc.hasNext()) {
			int count=0,end1=0;
			int[] memNumEnd=new int[flag+2];
			int start1=memoryAddress.indexOf("a");
			while(start1!=-1){
				while(memoryAddress.charAt(end1)=='a') end1++;
				memNumEnd[count]=end1-start1+1;
				count++;
				start1=memoryAddress.indexOf("a",end1);
				
			}
				System.out.println(count+1);
				for(int i=0;i<count;i++){
					System.out.println(memNumEnd[i]);
				}
		}
		return;
	}
	return ;
  }
}
