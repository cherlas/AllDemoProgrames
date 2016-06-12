package com.huawei.oj3;
import java.util.Scanner;

public class ConfigurationFilesRevovery {
	private static Scanner sc;
	private static String str;
	private static String[][] order={
			{"reset"},
			{"reset","board"},
			{"board","add"},
			{"board","delete"},
			{"reboot","backplane"},
			{"backplane","abort"}
	};
	private static String[] doThing={"reset what","board fault","where to add","no board at all",
			"impossible","install first","unkown command"};
	private static String[] inputCommand=new String[500];
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		int flag=0;
		while(sc.hasNextLine()){
			str=sc.nextLine();
			inputCommand[flag]=str;
			if (str.equals("")) {
				break;
			}
			flag++;
		}
		sc.close();
		
		for(int i=0;i<flag;i++){
			find(inputCommand[i]);
		}
		
	}
	private static void find(String string){
		if(!string.contains(" ")){
			int flag=0,k = 0;
			for(int i=0;i<order.length;i++){
				if (order[i][0].startsWith(string)&&order[i].length==1) {
					flag++;
					k=i;
				}
			}
			
			if(flag==1){
				print(k);
			}else {
				print(6);
			}
		}else {
			String[] inputs=new String[10];
				inputs=string.split(" ");
			if(inputs.length>2||string.endsWith(" ")){
				print(6);
			}else {
				int flag=0,k = 0;
				for(int i=0;i<order.length;i++){
					if(order[i].length>1){
					if (order[i][0].startsWith(inputs[0])&&order[i][1].startsWith(inputs[1])) {
						flag++;
						k=i;
					}
				}
				}
				if (flag==1) {
					print(k);
				}else {
					print(6);
				}	
			}
		}
	}
	
	private static void print(int k) {
		System.out.println(doThing[k]);
	}
}
