package com.revature.fileio.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {
	/*
	 *  2 ways for bytes
	 *  		InputStream/OutputStream: bytes
	 */
	
	public static void main(String[] args) {
		String filePath = "src/com/revature/fileio/serialization/byteExample.txt";
		String filePathOfJavaClass = "bin/com/revature/fileio/MainClass.class";
//		new ByteStreamExample().writeByte(filePath);
//		new ByteStreamExample().readBytes(filePath);
		
//		new ByteStreamExample().writeByte(filePathOfJavaClass);
		
		readClassFile(filePathOfJavaClass);
	}
	
	public void writeByte(String filePath) {
		//try w/Resources - introduced in Java 1.7
		
		try(OutputStream os = new FileOutputStream(filePath);) {
			os.write(65);
			os.write(66);
			os.write(67);
			os.write(68);
			os.write(69);
		}catch (FileNotFoundException e) {	
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readBytes(String filePath) {
		try ( InputStream is = new FileInputStream(filePath);) {
			int i;
			while((i = is.read()) != -1)
				System.out.print(i + " ");;
					
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readClassFile(String filePathOfJavaClass) {
		try ( InputStream is = new FileInputStream(filePathOfJavaClass);) {
			byte[] first4Bytes = new byte[4];
			is.read(first4Bytes);
			
			for(byte b : first4Bytes) {
				System.out.println(Integer.toHexString(b).substring(2));
			}
					
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
