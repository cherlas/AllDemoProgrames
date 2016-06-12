package 华为挑战;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 内存限制 {
	private static Scanner sc;
	private static int numOfMemAlloc,numOfFreeMen;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		numOfMemAlloc=sc.nextInt();
		Map<Integer, Integer> mem=new HashMap<>();
		for(int i=1;i<=numOfMemAlloc;i++){
			mem.put(i, sc.nextInt());
		}
		numOfFreeMen=sc.nextInt();
		for(int i=1;i<=numOfFreeMen;i++){
			int memNum=sc.nextInt();
			if (!(memNum<=numOfMemAlloc)) {
				System.exit(0);
			}else {
				mem.remove(memNum);
			}
		}
		
		if(mem.isEmpty()){
			System.out.println(0);
		}else {
			for(Integer k:mem.keySet()){
				System.out.println(mem.get(k));
			}
		}
	}
}
