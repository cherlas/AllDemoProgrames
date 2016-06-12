package com.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByteStream {

	public static void main(String[] args) {
		try {
			FileOutputStream fos=new FileOutputStream("testw.txt");
			byte[] bytes=new byte[50];
			String output="我家的傻地位到货时间回答我";
			bytes=output.getBytes("UTF-8");
			fos.write(bytes);
			
			
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
