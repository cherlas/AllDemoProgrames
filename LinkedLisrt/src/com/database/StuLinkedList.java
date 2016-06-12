package com.database;

class Node{
	int data;
	String names;
	int np;
	Node next;
	public Node(int data,String names,int np) {
		this.names=names;
		this.np=np;
		this.data=data;
	}
}
public class StuLinkedList {
	public Node first;
	public Node last;
	public boolean isEmpty(){
		return first==null;
	}
	public void print(){
		Node current=first;
		while(current!=null){
			System.out.println("["+current.data+" "+current.names+" "+current.np+"]");
			current=current.next;
		}
		System.out.println();
	}
	
	public void insert(int data,String names,int np){
		Node newNode=new Node(data,names,np);
		if (this.isEmpty()) {
			first=newNode;
			last=newNode;
		}else {
			last.next=newNode;
			last=newNode;
		}	
	}
	
	public void delete(Node delNode) {
		Node newNode;
		Node tmp;
		if (first.data==delNode.data) {
			first=first.next;
		}else if(last.data==delNode.data) {
			System.out.println("I'm here \n");
			newNode=first;
			while(newNode!=last) newNode=newNode.next;
			newNode.next=last.next;
			last=newNode;
		}else {
			tmp=first;
			newNode=first;
			while(newNode.data!=delNode.data){
				tmp=newNode;
				newNode=newNode.next;
			}
			tmp.next=delNode.next;
		}
	}
}
