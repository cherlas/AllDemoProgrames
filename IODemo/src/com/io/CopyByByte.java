package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyByByte {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("abc.jpg");
			byte[] bytes=new byte[20];
			//fis.read(bytes);
			
			FileOutputStream fos=new FileOutputStream("new abc.jpg");
			while (fis.read(bytes)!=-1) {
				fos.write(bytes);
				
			}
			
			
			fis.close();
			fos.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
