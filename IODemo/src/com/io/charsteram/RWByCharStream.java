package com.io.charsteram;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RWByCharStream {

	public static void main(String[] args) {
		//File file=new File("test.txt");
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			FileOutputStream fos=new FileOutputStream("test_new.txt");
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			char[] bytes=new char[100];
			int l=0;
			while((l=isr.read(bytes))!=-1){
				String str=new String(bytes, 0, l);
				osw.write(str);
			}
			isr.close();
			fis.close();
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
