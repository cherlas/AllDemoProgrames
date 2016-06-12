package com.database;

import java.io.IOException;
import java.util.Random;

public class ReverseStuLinkedList extends StuLinkedList
{
	public void reversePrint(){
		Node current=first;
		Node befor=null;
		
		while(current!=null){
			last=befor;
			befor=current;
			current=current.next;
			befor.next=last;
		}
		current=befor;
		
		while(current!=null){
			System.out.println("["+current.data+" "+current.names+" "+current.np+"]");
			current=current.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) throws IOException{
		Random random=new Random();
		ReverseStuLinkedList list=new ReverseStuLinkedList();
		int i,j,data[][]=new int[12][10];
		String[] name=new String[]{"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","MM"};
		System.out.println("---------学生成绩---------");
		
		for(i=0;i<12;i++){
			data[i][0]=i+1;
			data[i][1]=(Math.abs(random.nextInt(50)))+50;
			list.insert(data[i][0], name[i], data[i][1]);
		}
		for(i=0;i<3;i++){
			for (j = 0; j < 4; j++) {
				System.out.print("["+data[j*3+i][0]+"]"+" "+name[j*3+i]+" "+"["+data[j*3+i][1]+"]");
			}
			System.out.println();
		}
		list.reversePrint();
	}
}
