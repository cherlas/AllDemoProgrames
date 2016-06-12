package com.huawei.unsuccessed;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumPartner {
	private static Scanner sc;
	private static int[] nums;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int allNum=sc.nextInt();
		if (allNum<2||allNum%2!=0||allNum>30000) {
			System.out.println("Error");
		}else {
			nums=new int[allNum];
			boolean[] isVisited=new boolean[allNum];
			for(int i=0;i<allNum;i++){
				nums[i]=sc.nextInt();
				isVisited[i]=false;
			}
			Arrays.sort(nums);
			int max=0;
			while(nextPermutation()){
				int k=0;
				for(int j=0;j<allNum;j+=2){
					if (checkNum(nums[j]+nums[j+1])) {
						k++;
					}
				}
				if (k>max) {
					max=k;
				}
			}
			System.out.println(max);
		}
	}
private static boolean checkNum(int num) {
	for(int i=2;i<Math.sqrt((double)num);i++){
		if (num%i==0) {
			return false;
		}
	}
	return true;
}


public static boolean nextPermutation()  
{  
    if(nums.length <= 1)  
        return false;  
    for(int i = nums.length - 2; i >= 0; i--)  
    {  
        if(nums[i] < nums[i+1])  
        {  
            int j;  
            for(j = nums.length - 1; j >= i; j--)  
                if(nums[i] < nums[j])  
                    break;  
            // swap the two numbers.  
            nums[i] = nums[i] ^ nums[j];  
            nums[j] = nums[i] ^ nums[j];  
            nums[i] = nums[i] ^ nums[j];  
            //sort the rest of arrays after the swap point.  
            Arrays.sort(nums, i+1, nums.length);  
            return true;  
        }  
    }  
    //reverse the arrays.  
    for(int i = 0; i < nums.length / 2; i++)  
    {  
        int tmp = nums[i];  
        nums[i] = nums[nums.length - i - 1];  
        nums[nums.length - i - 1] = tmp;  
    }  
    return true;  
}
}
