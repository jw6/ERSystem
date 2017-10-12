package com.revature.fileio.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {

	/*
	 * 	2 ways for bytes 
	 * 			InputStream/OutputStream: bytes
	 * 		ObjectInputStream/ObjectOutputStream: Object to bytes-Serialization
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		String filePath = "src/com/revature/fileio/serialization/byteExample.txt";
		String filePathOfAjavaClassFile = "bin/com/revature/fileio/MainClass.class";
//		new ByteStreamExample().writeBytes(filePath);
//		readBytes(filePath);
		readClassFile(filePathOfAjavaClassFile);
	}
	
	public void writeBytes(String filePath){
		//try w/ Resources - added in java 1.7
		try (OutputStream os = new FileOutputStream(filePath);){
			os.write(65);
			os.write(66);
			os.write(67);
			os.write(68);
			os.write(69);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readBytes(String filePath){
		
		try (InputStream is = new FileInputStream(filePath);) {
			
			int i;
			while((i = is.read()) != -1){
				System.out.print(i + " ");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void readClassFile(String filePathOfAjavaClassFile){
		try (InputStream is = new FileInputStream(filePathOfAjavaClassFile);) {
			byte[] first4Bytes = new byte[4];
			is.read(first4Bytes);
			
			//Read first 4 bytes of a class - cafebabe
			for(byte b : first4Bytes){
				System.out.print(Integer.toHexString(b).substring(6)); 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
