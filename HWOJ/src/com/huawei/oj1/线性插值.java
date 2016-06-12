package com.huawei.oj1;

import java.util.Scanner;

class Messure{
	int order;
	int value;
	Messure next;
	public Messure(int order,int value,Messure messure) {
		this.order=order;
		this.value=value;
		this.next=messure;
	}
}
public class 线性插值 {
	private static Scanner sc;
	private static int m;
	private static Messure firstMessure;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		m=sc.nextInt();
		int n=sc.nextInt();
		Messure tmp1 = null,tmp2=null;
		for(int i=0;i<m;i++)
			if (i==0) {
				firstMessure=new Messure(sc.nextInt(), sc.nextInt(),null);				
				tmp1=firstMessure;
			}else {
				int k=sc.nextInt();
				int v=sc.nextInt();
				if (!ContainOrder(k,firstMessure)) {
					continue;
				}else {
					tmp2=new Messure(k, v, null);
					tmp1.next=tmp2;
					tmp1=tmp2;
				}
			}					
		tmp1=firstMessure;
		while(tmp1!=null){
			tmp2=tmp1.next;
			if (tmp2==null) {
				break;
			}
			if (((tmp1.order)+1)==(tmp2.order)) {
				tmp1=tmp2;
			}else {
				Messure tmp3=tmp1,tmp4=tmp2;
				for(int i=1;i<=tmp2.order-tmp1.order-1;i++){
					int k=tmp1.order+i;
					int v=tmp1.value+(tmp2.value-tmp1.value)/(tmp2.order-tmp1.order)*i;
					Messure ins=new Messure(k, v, null);
					tmp3.next=ins;
					tmp3=ins;
				}
				tmp3.next=tmp4;
			}	
			tmp1=tmp2;
		}
		tmp1=firstMessure;
		while(tmp1!=null){
			System.out.println(tmp1.order+" "+tmp1.value);
			tmp1=tmp1.next;
//			if (tmp1!=null) {
//				System.out.print(" ");
//			}
		}
		System.out.println();
	}
private static boolean ContainOrder(int k,Messure fMessure) {
	while(fMessure!=null){
		if (fMessure.order==k) {
			return false;
		}
		fMessure=fMessure.next;
	}
	return true;
}
}
