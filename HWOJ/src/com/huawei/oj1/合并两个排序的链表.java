package com.huawei.oj1;


//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
//public class 合并两个排序的链表 {
//	private static ListNode tmp1;
//	public static void main(String[] args) {
//		ListNode listNode1=new ListNode(1);
//		ListNode listNode2=new ListNode(2);
//		ListNode f1=listNode1,f2=listNode2;
//		for(int i=1;i<3;i++){
//			f1.next=new ListNode(2*i+1);
//			f2.next=new ListNode(2*i+2);
//			f1=f1.next;
//			f2=f2.next;
//		}		
//		ListNode head=Merge(listNode1, listNode2);
//		while(head!=null){
//			System.out.println(head.val);
//			head=head.next;
//		}
//	}
//	
//	 public static ListNode Merge(ListNode list1,ListNode list2) {
//	        if(list1==null) return list2;
//	        if(list2==null) return list1;
//	        tmp1 = null;
//	        ListNode tmp2;
//			ListNode head=null,bigger=null;
//	        if (list1.val <list2.val) {
//				head=list1;
//				bigger=list2;
//			}else {
//				head=list2;
//				bigger=list1;
//			}
//	        tmp1=head;
//	        ListNode pre=null;
//	        while(true){	        	
//	        	while(tmp1!=null&&tmp1.val<=bigger.val){
//	        		pre=tmp1;
//	        		tmp1=tmp1.next;
//	        	}		        	
//	        	if (tmp1==null) {
//					break;
//				}else {				
//					tmp2=bigger.next;
//					pre.next=bigger;
//					bigger.next=tmp1;
//					bigger=tmp2;
//				}
//	        	if (bigger==null) {
//					break;
//				}
//	        }
//	        if (bigger!=null) {
//				pre.next=bigger;
//			}
//	        return head;
//	    }
//}
