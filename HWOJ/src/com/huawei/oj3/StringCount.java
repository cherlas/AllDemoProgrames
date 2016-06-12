package com.huawei.oj3;
import java.util.Scanner;

public class StringCount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int englishCharCount=getEnglishCharCount(str);
		System.out.println(englishCharCount);
		int blankCharCount=getBlankCharCount(str);
		System.out.println(blankCharCount);
		int numberCharCount=getNumberCharCount(str);
		System.out.println(numberCharCount);
		System.out.println((str.length()-englishCharCount-blankCharCount-numberCharCount));
	}
	/**
     * 统计出英文字母字符的个数。
     * 
     * @param str 需要输入的字符串
     * @return 英文字母的个数
     */
public static int getEnglishCharCount(String str) {
	int num=0;
	for (int i = 0; i < str.length(); i++) {
		if ((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='A'&&str.charAt(i)<='Z')) {
			num++;
		}
	}
	return num;
  }
/**
 * 统计出空格字符的个数。
 * 
 * @param str 需要输入的字符串
 * @return 空格的个数
 */
public static int getBlankCharCount(String str) {
	int num=0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)==' ') {
			num++;
		}
	}
	return num;
  }
/**
 * 统计出数字字符的个数。
 * 
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 */

public static int getNumberCharCount(String str) {
	int num=0;
	for (int i = 0; i < str.length(); i++) {
		if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
			num++;
		}
	}
	return num;
  }
/**
 * 统计出其它字符的个数。
 * 
 * @param str 需要输入的字符串
 * @return 英文字母的个数
 */
//public static int getOtherCharCount(String str) {
//	int num=0;
//	for (int i = 0; i < str.length(); i++) 
//		if (str.charAt(i)<'a'||str.charAt(i)>'z'||str.charAt(i)<'A'||str.charAt(i)>'Z'||str.charAt(i)<'0'||str.charAt(i)>'9'||str.charAt(i)!=' '){
//			num++;
//		}
//	return num;
//   }
}
