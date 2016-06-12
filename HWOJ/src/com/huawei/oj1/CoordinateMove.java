package com.huawei.oj1;

import java.util.Scanner;

public class CoordinateMove {
	
	private static Scanner sc;
	private static String[] coordinates;
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		coordinates=sc.nextLine().split(";");
		int pointX=0,pointY=0;
		for(int i=0;i<coordinates.length;i++){
			if (checkCoordinate(coordinates[i])) {
				String sub=coordinates[i].substring(1, coordinates[i].length());
				int move=Integer.parseInt(sub);
				switch (coordinates[i].charAt(0)) {
				case 'W':
					pointY+=move;
					break;
				case 'S':
					pointY-=move;
					break;
				case 'A':
					pointX-=move;
					break;
				case 'D':
					pointX+=move;
					break;
				}
			}
		}
		System.out.println(pointX+","+pointY);

	}
private static boolean checkCoordinate(String str) {
		if (str.isEmpty()) {
			return false;
		}
		str.trim();
		if (!(str.startsWith("W")||str.startsWith("A")||str.startsWith("S")||str.startsWith("D"))) {
			return false;
		}else if(str.length()<2||str.length()>3) {
			return false;
		}else {
			for(int i=1;i<str.length();i++){
				char c=str.charAt(i);
				if(!(c>='0'&&c<='9'))
					return false;
			}
		}
	return true;
}
}
