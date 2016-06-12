package com.huawei.oj1;

import java.util.Scanner;

class ListNode{
	int value;
	ListNode next;
public ListNode() {
	this.value=0;
	this.next=null;
   }
public ListNode(int value,ListNode next){
	this.value=value;
	this.next=next;
}
}
public class 从单向链表中删除指定值的节点 {
	private static Scanner sc;
	public static void main(final String[] args){
		sc=new Scanner(System.in);
		int num=sc.nextInt();
		ListNode first=null;
		for(int i=0;i<num;i++){
			if (i==0) {
				first=new ListNode(sc.nextInt(),null);
			}else {
				int value=sc.nextInt();
				int key=sc.nextInt();
				ListNode tmp=first;
				while(tmp!=null){
					if (tmp.value==key) {
						ListNode n=tmp.next;
						tmp.next=new ListNode(value,n);
						break;
					}
					tmp=tmp.next;
				}
			}
		}
		int delete=sc.nextInt();
		first=deleteNode(first,delete);
		if (first==null) {
			
		}else {
			ListNode tmp=first;
			while(tmp!=null){
			System.out.print(tmp.value);
			if (tmp.next!=null) {
				System.out.print(" ");
			}
			tmp=tmp.next;
		}
		}		
	}
	
	private static ListNode deleteNode(ListNode ln,int n) {
		ListNode tmp = ln;
		ListNode befor=ln;
		while(tmp!=null){
			if (tmp.value==n) {
				if (befor==ln) {
					ln=tmp.next;
					break;
				}else {
					befor.next=tmp.next;
					break;
				}
			}else {
				befor=tmp;
				tmp=tmp.next;
			}
			
		}
		return ln;
	}
}
