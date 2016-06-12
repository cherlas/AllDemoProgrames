package 编程之美;

import java.util.Arrays;

public class 方法值传递 {

	public static void main(String[] args) {
		int[] original=new int[]{4,2,1,8,5,9};
		sort(original);
		for(Integer integer:original){
			System.err.println(integer);
		}System.out.println(Math.sin(Math.toRadians(30)));
		String string="the square root of 2.0 is "+Math.sqrt(2.0);
		System.out.println(string);
		System.out.println((2.0e-6*100000000.1));
//		Scanner sc=new Scanner(System.in);
//		while(sc.hasNext()){
//			System.out.println(sc.next());
//		}
		double t=9.0;
		while(Math.abs(t-9.0/t)>.001){
			t=(9.0/t+t)/ (2.0);
		}
		System.out.printf("%.5f\n",t);
		
		//int[] a = null;

	}
private static void sort(int[] A){
	Arrays.sort(A);
	for(Integer integer:A){
		System.out.println(integer);
		
	}
}
}
