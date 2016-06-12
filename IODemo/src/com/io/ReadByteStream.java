package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadByteStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			byte[] input=new byte[23];
			fis.read(input);
			String str=new String(input,"UTF-8");
			
			System.out.println(str);
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
