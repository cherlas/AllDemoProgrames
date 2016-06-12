package com.io.charsteram;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class RWByBufferedStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("test.txt");
			FileOutputStream fos=new FileOutputStream("test_new_buffer.txt");
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			
			BufferedReader br=new BufferedReader(isr);
			//BufferedWriter bw=new BufferedWriter(osw);
			PrintWriter pw=new PrintWriter(osw,true);
			
			String str;
			while ((str=br.readLine())!=null) {
				//bw.write(str);//不带回车  
				pw.println(str);
			}
			/*
			char[] bytes=new char[100];
			int l=0;
			while((l=isr.read(bytes))!=-1){
				String str=new String(bytes, 0, l);
				osw.write(str);
			}*/
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
