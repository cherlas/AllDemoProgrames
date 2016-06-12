package com.huawei.oj1;

import java.util.Scanner;

public class 第K个节点 {	
private static class ListNode{
		private int m_nKey;
		public int getM_nKey() {
			return m_nKey;
		}
		public void setM_nKey(int m_nKey) {
			this.m_nKey = m_nKey;
		}
	}	
	private static Scanner sc;
	private static int num;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		num=sc.nextInt();
		ListNode[] listNode=new ListNode[num];
		for(int i=num-1;i>=0;i--){
			listNode[i]=new ListNode();
			listNode[i].setM_nKey(sc.nextInt());
		}
		int k=sc.nextInt();
		if(k>num||k<0){
			System.out.println();
		}else {
			System.out.println(listNode[k].getM_nKey());
		}	
	}
}
