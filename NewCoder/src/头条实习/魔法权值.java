package 头条实习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 魔法权值 {
	private static Scanner sc;
	private static int n,k;
	private static List<String> strings=new ArrayList<>();
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			int k=sc.nextInt();
			if (n>8||k>200) {
				System.out.println(0);
			}else {
				String[] input=new String[n];
				for(int i=0;i<n;i++){
					input[i]=sc.next();
				}
				
				sort(Arrays.asList(input), new ArrayList<>(),n);
				List<Integer> list=doSome();
				int count=0;
				for(Integer i:list)
					if(i==k) count++;
				System.out.println(count);
			}
		}
		
	}
private static List<Integer> doSome() {
	List<Integer> result=new ArrayList<>();
		for(String string:strings){			
			result.add(calculate(n, k,string)) ;
		}
	
	return result;
}
private static int calculate(int n,int k,String str){
	int count=0;
	for(int i=1;i<=str.length();i++){
		String tmpStr=str.substring(i,str.length())+str.substring(0,i);
			if (tmpStr.equals(str)) {
				count++;
			}
	}
	
	return count;
}
private static void sort(List datas, List target,int n) {  
    if (target.size() == n) {  
    	StringBuffer sb=new StringBuffer();
        for (Object obj : target)  
            sb.append(obj) ; 
        strings.add(sb.toString());
        return;  
    }  
    for (int i = 0; i < datas.size(); i++) {  
        List<String> newDatas = new ArrayList<String>(datas);  
        List<String> newTarget = new ArrayList<String>(target);  
        newTarget.add(newDatas.get(i));  
        newDatas.remove(i);  
        sort(newDatas, newTarget,n);  
    }  
}  
}
