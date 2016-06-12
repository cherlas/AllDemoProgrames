package error;

import java.util.*;
public class 单独的数字{
    private static Scanner sc;
    private static int[] input;
    public static void main(String[] args){
        sc=new Scanner(System.in);
        int n=sc.nextInt();
        input =new int[n];
        for(int i=0;i<n;i++) input[i]=sc.nextInt();
        System.out.println(findOnlyOne(n));
    }
	private static int findOnlyOne(int n) {
		// TODO Auto-generated method stub
		
//		Map<Integer, Integer> map=new HashMap<>();
//		for(int i=0;i<n;i++){
//			if (!map.containsKey(input[i])) {
//				map.put(input[i], new Integer(1));
//			}else {
//				int s=map.get(input[i]);
//				s++;
//				map.remove(input[i]);
//				map.put(input[i], new Integer(s));
//			}
//		}
//		for(Integer i:map.keySet())
//			if (map.get(i)==1) 
//				return i;
		 Arrays.sort(input);
	        for(int i=0;i<n;){
	            int s=input[i];
	            int j=i+1;
	            while(j<n&&input[j]==s) j++;
	            if(j-i==1) return input[i];
	            i=j;
	        }
	    
		return 0;
	}	
}