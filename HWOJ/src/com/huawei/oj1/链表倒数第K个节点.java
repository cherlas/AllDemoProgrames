package com.huawei.oj1;

public class 链表倒数第K个节点 {
	
	 class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	    public ListNode FindKthToTail(ListNode head,int k) {
			ListNode listNode1=head;
	        ListNode listNode2=head;
	        for(int i=0;i<k-1;i++){
	        	if (listNode2==null) {
					return null;
				}else {
					listNode2=listNode2.next;
				}
	        }
	        while(listNode2!=null){
	        	listNode1=listNode1.next;
	        	listNode2=listNode2.next;
	        }
			return listNode1;       
	    }
	}


